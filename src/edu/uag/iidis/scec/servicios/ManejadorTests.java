package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Test;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TestDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorTests {
    private Log log = LogFactory.getLog(ManejadorTests.class);
    private TestDAO dao;

    public ManejadorTests() {
        dao = new TestDAO();
    }


    public Collection listarTests() {
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

    public void eliminarTest(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarTest(test)");
        }
        try {
            HibernateUtil.beginTransaction();
            Test test = dao.buscarPorId(id, true);
            if (test != null) {
              dao.hazTransitorio(test);
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

    public int crearTest(Test test) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarTest(test)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (dao.existeTest(test.getTitle())) {
               resultado = 1; // Excepción. El nombre de rol ya existe
            } else {

               dao.hazPersistente(test);

               resultado = 0; // Exito. El rol se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
			e.printStackTrace();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }

    public int modificarTest(Test test) {/****/

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">ModificarTest(test)");
        }

        try {
            HibernateUtil.beginTransaction();

            dao.hazModificacion(test);
            resultado = 0; // Exito porque existe y va a modificar


            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }

    public Test buscarById(Long id) {
        Test resultado;

        if (log.isDebugEnabled()) {
            log.debug(">BuscarIDQuestion(idQuestion)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarPorId(id, true);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

     public Test buscarByName(String id) {
        Test resultado;

        if (log.isDebugEnabled()) {
            log.debug(">BuscarIDQuestion(idQuestion)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarByName(id);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
