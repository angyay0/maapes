package edu.uag.iidis.scec.servicios;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.UserAnswer;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.UserAnswerDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorUserAnswer {
    private Log log = LogFactory.getLog(ManejadorUserAnswer.class);
    private UserAnswerDAO dao;

    public ManejadorUserAnswer() {
        dao = new UserAnswerDAO();
    }
    
    public Collection listarByTest(Long idTry) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarByTest(idTry);
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

    public int crearUserAnswer(UserAnswer ts) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUserAnswer(question)");
        }

        try {
            HibernateUtil.beginTransaction();

            if ( dao.existe( ts.getIdTry(),ts.getIdAnswer() ) ) {
            	/*Collection c = dao.getByComps( ts.getIdTry(),ts.getIdAnswer() );
            	for(Iterator<UserAnswer> it=c.iterator(); it.hasNext(); ) {
						
					UserAnswer tss = (UserAnswer) it.next();
					if (tss != null) {
						dao.hazTransitorio(tss);
					}
				//	HibernateUtil.commitTransaction();
					
            	}*/
               resultado = 1; // Excepcion. El nombre de question ya existe
            } else {/*
			   	Collection c = dao.getByComps( ts.getIdTry(),ts.getIdAnswer() );
            	for(Iterator<UserAnswer> it=c.iterator(); it.hasNext(); ) {
						
					UserAnswer tss = (UserAnswer) it.next();
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
