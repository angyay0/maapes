package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Question;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.QuestionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorQuestions {
    private Log log = LogFactory.getLog(ManejadorRoles.class);
    private QuestionDAO dao;

    public ManejadorQuestions() {
        dao = new QuestionDAO();
    }


    public Collection listarQuestions() {
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

    public Collection listarBySection(Long idSection) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarBySection(idSection);
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

    public Collection buscarQuestions(String questionBuscar) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorNombre(questionBuscar);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

      public Question buscarQuestion(Long idQuestion) {
        Question resultado;

        if (log.isDebugEnabled()) {
            log.debug(">BuscarIDQuestion(idQuestion)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorId(idQuestion, true);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarQuestion(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarQuestion(question)");
        }
        try {
            HibernateUtil.beginTransaction();
            Question question = dao.buscarPorId(id, true);
            if (question != null) {
              dao.hazTransitorio(question);
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

    public int crearQuestion(Question question) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarQuestion(question)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (dao.existeQuestion(question.getText())) {
               resultado = 1; // Excepci�n. El nombre de question ya existe
            } else {

               dao.hazPersistente(question);

               resultado = 0; // Exito. El question se creo satisfactoriamente.
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

     public int modificarQuestion(Question question) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">modificarQuestion(question)");
        }

        try {
            HibernateUtil.beginTransaction();

            dao.hazModificacion(question);
            resultado = 0; // Exito. Question Modificada

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
