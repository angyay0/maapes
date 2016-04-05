package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Section;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class SectionDAO {

    private Log log = LogFactory.getLog(SectionDAO.class);

    public SectionDAO() {
    }


    public Section buscarPorId(Long idSection, boolean bloquear)
            throws ExcepcionInfraestructura {

        Section section = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idSection + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                section = (Section)HibernateUtil.getSession()
                                                .load(Section.class, 
                                                      idSection, 
                                                      LockMode.UPGRADE);
            } else {
                section = (Section)HibernateUtil.getSession()
                                                .load(Section.class,
                                                      idSection);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return section;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection sections;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            sections = HibernateUtil.getSession()
                                    .createCriteria(Section.class)
                                    .list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return sections;
    }


    public Collection buscarPorEjemplo(Section section)
            throws ExcepcionInfraestructura {


        Collection sections;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Section.class);
            sections = criteria.add(Example.create(section)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return sections;
    }


    public void hazPersistente(Section section)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(section)");
        }

        try {
        	System.out.println("AQUI WEON");
        	System.out.println(section.getId()+"-"+section.getTitle());
            HibernateUtil.getSession().saveOrUpdate(section);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            e.printStackTrace();
            System.out.println("AQUI WEON");
        	System.out.println(section.getId()+"-"+section.getTitle());
            throw new ExcepcionInfraestructura(e);
        }
    }

    public void hazModificacion(Section section)/****/
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(section)");
        }

        try {
        	System.out.println(section.getId());
        	System.out.println(section.getTitle());
            HibernateUtil.getSession().update(section);
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


    public void hazTransitorio(Section section)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(section)");
        }

        try {
            HibernateUtil.getSession().delete(section);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeSection(String title)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeSection(nombreSection)");
        }

        try {
 
			String hql = "select title from Section where title = :title";
			
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


}
