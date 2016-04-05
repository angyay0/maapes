package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Test;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class TestDAO {

    private Log log = LogFactory.getLog(TestDAO.class);

    public TestDAO() {
    }


    public Test buscarPorId(Long idTest, boolean bloquear)
            throws ExcepcionInfraestructura {

        Test test = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idTest + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                test = (Test)HibernateUtil.getSession()
                                                .load(Test.class,
                                                      idTest,
                                                      LockMode.UPGRADE);
            } else {
                test = (Test)HibernateUtil.getSession()
                                                .load(Test.class,
                                                      idTest);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return test;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection tests;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            tests = HibernateUtil.getSession()
                                    .createCriteria(Test.class)
                                    .list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return tests;
    }


    public Collection buscarPorEjemplo(Test test)
            throws ExcepcionInfraestructura {


        Collection tests;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Test.class);
            tests = criteria.add(Example.create(test)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return tests;
    }


    public void hazPersistente(Test test)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(test)");
        }

        try {
        	System.out.println("AQUI WEON");
        	System.out.println(test.getId()+"-"+test.getTitle());
            HibernateUtil.getSession().saveOrUpdate(test);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            e.printStackTrace();
            System.out.println("AQUI WEON");
        	System.out.println(test.getId()+"-"+test.getTitle());
            throw new ExcepcionInfraestructura(e);
        }
    }

    public void hazModificacion(Test test)/****/
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(test)");
        }

        try {
        	System.out.println(test.getId());
        	System.out.println(test.getTitle());
            HibernateUtil.getSession().update(test);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
                e.printStackTrace();
            }
            System.out.println("<<V3RG4>>");
            e.printStackTrace();
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Test test)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(test)");
        }

        try {
            HibernateUtil.getSession().delete(test);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeTest(String title)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeTest(nombreTest)");
        }

        try {

			String hql = "select title from Test where title = :title";

			 if (log.isDebugEnabled()) {
           		 log.debug(hql + title);
        	}

			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("title", title);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
        	}
			List results = query.list();
			int resultado = results.size();
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< Result size " + resultado);
        	}
            if (resultado == 0) {
               return false;
            }

            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            ex.printStackTrace();
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public Test buscarByName(String title)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeTest(nombreTest)");
        }

        try {

			String hql = "select id from Test where title = :title";

			 if (log.isDebugEnabled()) {
           		 log.debug(hql + title);
        	}

			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("title", title);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
        	}
			List results = query.list();
			int resultado = results.size();
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< Result size " + resultado);
        	}
            if (resultado == 0) {
               return null;
            }

            return (buscarPorId((Long)results.get(0),true));

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            ex.printStackTrace();
            throw new ExcepcionInfraestructura(ex);
        }
    }


}
