package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Answer;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.AnswerDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorAnswers {
    private Log log = LogFactory.getLog(ManejadorRoles.class);
    private AnswerDAO dao;

    public ManejadorAnswers() {
        dao = new AnswerDAO();
    }


    public Collection listarAnswers() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            e.printStackTrace();
            return null;
        } finally {
            try{
            	HibernateUtil.closeSession();
            }catch(Exception e){
				e.printStackTrace();
            }
        }
    }

    public Collection listarByQuestion(Long idQuestion) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarByQuestion(idQuestion);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            e.printStackTrace();
            return null;
        } finally {
            try{
            	HibernateUtil.closeSession();
            }catch(Exception e){
				e.printStackTrace();
            }
        }
    }

    public Collection buscarAnswers(String answerBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorNombre(answerBuscar);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

      public Answer buscarAnswer(Long idAnswer) {
        Answer resultado;

        if (log.isDebugEnabled()) {
            log.debug(">BuscarIDAnswer(idAnswer)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorId(idAnswer, true);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarAnswer(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarAnswer(answer)");
        }
        try {
            HibernateUtil.beginTransaction();
            Answer answer = dao.buscarPorId(id, true);
            if (answer != null) {
              dao.hazTransitorio(answer);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearAnswer(Answer answer) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarAnswer(answer)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (dao.existeAnswer(answer.getText())) {
               resultado = 1; // Excepci�n. El nombre de answer ya existe
            } else {

               dao.hazPersistente(answer);

               resultado = 0; // Exito. El answer se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepci�n. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }

     public int modificarAnswer(Answer answer) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">modificarAnswer(answer)");
        }

        try {
            HibernateUtil.beginTransaction();

            dao.hazModificacion(answer);
            resultado = 0; // Exito. Answer Modificada

            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
			e.printStackTrace();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepci�n. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }

}
