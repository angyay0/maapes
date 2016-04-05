package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Section;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.SectionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorSections {
    private Log log = LogFactory.getLog(ManejadorSections.class);
    private SectionDAO dao;

    public ManejadorSections() {
        dao = new SectionDAO();
    }

    public Section obtenerSection(long id) 
            throws ExcepcionServicio {

        if (log.isDebugEnabled()) {
            log.debug(">obtenerSection(" + id + ")");
        }

        try {
            return dao.buscarPorId(id,false);
        } catch (ExcepcionInfraestructura e) {
            log.error("<ExcepcionInfraestructura");
            throw new ExcepcionServicio(e.getMessage(), e);
        }
    }

    public Collection listarSections() {
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

    public void eliminarSection(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarSection(section)");
        }
        try {
            HibernateUtil.beginTransaction();           
            Section section = dao.buscarPorId(id, true);
            if (section != null) {
              dao.hazTransitorio(section);
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

    public int crearSection(Section section) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarSection(section)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeSection(section.getTitle())) {
               resultado = 1; // Excepción. El nombre de rol ya existe
            } else {

               dao.hazPersistente(section);

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

    public int modificarSection(Section section) {/****/

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">ModificarSection(section)");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            dao.hazModificacion(section);
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
}
