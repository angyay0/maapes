package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Question;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class QuestionDAO {

    private Log log = LogFactory.getLog(QuestionDAO.class);

    public QuestionDAO() {
    }


    public Question buscarPorId(Long idQuestion, boolean bloquear)
            throws ExcepcionInfraestructura {

        Question question = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idQuestion + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                question = (Question)HibernateUtil.getSession()
                                                .load(Question.class, 
                                                      idQuestion, 
                                                      LockMode.UPGRADE);
            } else {
                question = (Question)HibernateUtil.getSession()
                                                .load(Question.class,
                                                      idQuestion);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return question;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection questions;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            questions = HibernateUtil.getSession()
                                    .createCriteria(Question.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return questions;
    }

    public Collection buscarBySection(Long idSection)
            throws ExcepcionInfraestructura {

        Collection questions;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            questions = HibernateUtil.getSession()
                                    .createCriteria(Question.class).add(Restrictions.eq("idSection", idSection))
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return questions;
    }


    public Collection buscarPorEjemplo(Question question)
            throws ExcepcionInfraestructura {


        Collection questions;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Question.class);
            questions = criteria.add(Example.create(question)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return questions;
    }


    public void hazPersistente(Question question)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(question)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(question);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

	public void hazModificacion(Question question)/*******/
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazModificacion(question)");
        }

        try {
        	System.out.println(question.getId());
        	System.out.println(question.getText());
        	System.out.println(question.getidSection());
            HibernateUtil.getSession().update(question);
        } catch (Exception e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            System.out.println("<<V3RG4>>");/****/
            e.printStackTrace();
            throw new ExcepcionInfraestructura(e);
        }
    }

    public void hazTransitorio(Question question)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(question)");
        }

        try {
            HibernateUtil.getSession().delete(question);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            
            throw new ExcepcionInfraestructura(e);
        }
    }
    public Collection buscarPorNombre(String nombreQuestion)
            throws ExcepcionInfraestructura {

        Collection questions;

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
            
            String hql = "from Question where text LIKE :text";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreQuestion);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("text", "%"+nombreQuestion+"%");

            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            questions = query.list();

            return questions;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public boolean existeQuestion(String nombreQuestion)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
			
			
//            String consultaCuentaRoles =
//            "select count(*) from Question r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			String hql = "select text from Question where text = :text";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreQuestion);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("text", nombreQuestion);
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
            throw new ExcepcionInfraestructura(ex);
        }
    }


}
