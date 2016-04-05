package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.UserAnswer;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class UserAnswerDAO {

    private Log log = LogFactory.getLog(UserAnswerDAO.class);

    public UserAnswerDAO() {
    }


     public boolean existe(Long idTry,Long idAnswer)
            throws ExcepcionInfraestructura {

        Collection rels;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            rels = HibernateUtil.getSession()
                                    .createCriteria(UserAnswer.class).add(Restrictions.eq("idTry", idTry)).add(Restrictions.eq("idAnswer", idAnswer))
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
     public Collection getByComps(Long idTry,Long idAnswer)
            throws ExcepcionInfraestructura {

        Collection rels;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            rels = HibernateUtil.getSession()
                                    .createCriteria(UserAnswer.class).add(Restrictions.eq("idTry", idTry)).add(Restrictions.eq("idAnswer", idAnswer))
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
    public Collection buscarByTest(Long idTry)
            throws ExcepcionInfraestructura {

        Collection rels;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            rels = HibernateUtil.getSession()
                                    .createCriteria(UserAnswer.class).add(Restrictions.eq("idTry", idTry))
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

    public void hazPersistente(UserAnswer ts)
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

    public void hazTransitorio(UserAnswer ts)
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
