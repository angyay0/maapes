package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.TestSection;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class TestSectionDAO {

    private Log log = LogFactory.getLog(TestSectionDAO.class);

    public TestSectionDAO() {
    }


     public boolean existe(Long idTest,Long idSection)
            throws ExcepcionInfraestructura {

        Collection rels;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            rels = HibernateUtil.getSession()
                                    .createCriteria(TestSection.class).add(Restrictions.eq("idTest", idTest)).add(Restrictions.eq("idSection", idSection))
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        if( rels == null || rels.size() < 1 ){
        	return false;
    	}

        return true;
    }
/*
     public Collection getByComps(Long idTest,Long idSection)
            throws ExcepcionInfraestructura {

        Collection rels;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            rels = HibernateUtil.getSession()
                                    .createCriteria(TestSection.class).add(Restrictions.eq("idTest", idTest)).add(Restrictions.eq("idSection", idSection))
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        
        return rels;
    }
*/
    public Collection buscarByTest(Long idTest)
            throws ExcepcionInfraestructura {

        Collection rels;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            rels = HibernateUtil.getSession()
                                    .createCriteria(TestSection.class).add(Restrictions.eq("idTest", idTest))
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return rels;
    }

    public void hazPersistente(TestSection ts)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">haPersistente(answer)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(ts);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public void hazTransitorio(TestSection ts)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">haTransitorio(answer)");
        }

        try {
            HibernateUtil.getSession().delete(ts);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            
            throw new ExcepcionInfraestructura(e);
        }
    }
}
