package edu.uag.iidis.scec.servicios;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Try;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TryDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorTry {
    private Log log = LogFactory.getLog(ManejadorTry.class);
    private TryDAO dao;

    public ManejadorTry() {
        dao = new TryDAO();
    }
    
    public Collection listarByTest(Long idTest) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">listarByTest(test)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarByTest(idTest);
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

    public int crearTry(Try ts) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarTry(try)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = 0; // Excepcion. El nombre de question ya existe
            dao.hazPersistente(ts);
            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
           // e.getMessage();
            log.warn("WEON - "+e.getMessage() );
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
