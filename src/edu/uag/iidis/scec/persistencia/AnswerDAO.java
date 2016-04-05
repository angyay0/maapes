package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Answer;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class AnswerDAO {

    private Log log = LogFactory.getLog(AnswerDAO.class);

    public AnswerDAO() {
    }


    public Answer buscarPorId(Long idAnswer, boolean bloquear)
            throws ExcepcionInfraestructura {

        Answer answer = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idAnswer + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                answer = (Answer)HibernateUtil.getSession()
                                                .load(Answer.class, 
                                                      idAnswer, 
                                                      LockMode.UPGRADE);
            } else {
                answer = (Answer)HibernateUtil.getSession()
                                                .load(Answer.class,
                                                      idAnswer);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return answer;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection answers;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            answers = HibernateUtil.getSession()
                                    .createCriteria(Answer.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return answers;
    }

    public Collection buscarByQuestion(Long idQuestion)
            throws ExcepcionInfraestructura {

        Collection answers;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            answers = HibernateUtil.getSession()
                                    .createCriteria(Answer.class).add(Restrictions.eq("idQuestion", idQuestion))
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return answers;
    }


    public Collection buscarPorEjemplo(Answer answer)
            throws ExcepcionInfraestructura {


        Collection answers;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Answer.class);
            answers = criteria.add(Example.create(answer)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return answers;
    }


    public void hazPersistente(Answer answer)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(answer)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(answer);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

	public void hazModificacion(Answer answer)/*******/
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazModificacion(answer)");
        }

        try {
        	System.out.println(answer.getId());
        	System.out.println(answer.getText());
        	System.out.println(answer.getidQuestion());
        	System.out.println(answer.getRgt());
            HibernateUtil.getSession().update(answer);
        } catch (Exception e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            System.out.println("<<V3RG4>>");/****/
            e.printStackTrace();
            throw new ExcepcionInfraestructura(e);
        }
    }

    public void hazTransitorio(Answer answer)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(answer)");
        }

        try {
            HibernateUtil.getSession().delete(answer);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            
            throw new ExcepcionInfraestructura(e);
        }
    }
    public Collection buscarPorNombre(String nombreAnswer)
            throws ExcepcionInfraestructura {

        Collection answers;

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
            
            String hql = "from Answer where text LIKE :text";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAnswer);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("text", "%"+nombreAnswer+"%");

            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            answers = query.list();

            return answers;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public boolean existeAnswer(String nombreAnswer)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
			
			
//            String consultaCuentaRoles =
//            "select count(*) from Answer r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			String hql = "select text from Answer where text = :text";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreAnswer);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("text", nombreAnswer);
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
