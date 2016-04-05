package edu.uag.iidis.scec.servicios;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.TestSection;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TestSectionDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorTestSection {
    private Log log = LogFactory.getLog(ManejadorTestSection.class);
    private TestSectionDAO dao;

    public ManejadorTestSection() {
        dao = new TestSectionDAO();
    }
    
    public Collection listarByTest(Long idTest) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
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

    public int crearTestSection(TestSection ts) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarTestSection(question)");
        }

        try {
            HibernateUtil.beginTransaction();

            if ( dao.existe( ts.getIdTest(),ts.getIdSection() ) ) {
            	/*Collection c = dao.getByComps( ts.getIdTest(),ts.getIdSection() );
            	for(Iterator<TestSection> it=c.iterator(); it.hasNext(); ) {
						
					TestSection tss = (TestSection) it.next();
					if (tss != null) {
						dao.hazTransitorio(tss);
					}
				//	HibernateUtil.commitTransaction();
					
            	}*/
               resultado = 1; // Excepcion. El nombre de question ya existe
            } else {/*
			   	Collection c = dao.getByComps( ts.getIdTest(),ts.getIdSection() );
            	for(Iterator<TestSection> it=c.iterator(); it.hasNext(); ) {
						
					TestSection tss = (TestSection) it.next();
					if (tss != null) {
						dao.hazTransitorio(tss);
				}*/
               dao.hazPersistente(ts);

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
}
