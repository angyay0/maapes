package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.MPersona;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class MPersonaDAO {

    private Log log = LogFactory.getLog(MPersonaDAO.class);

    public MPersonaDAO() {
    }


    public MPersona buscarPorId(Long idMPersona, boolean bloquear)
            throws ExcepcionInfraestructura {

        MPersona MPersona = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idMPersona + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                MPersona = (MPersona)HibernateUtil.getSession()
                                                .load(MPersona.class, 
                                                      idMPersona, 
                                                      LockMode.UPGRADE);
            } else {
                MPersona = (MPersona)HibernateUtil.getSession()
                                                .load(MPersona.class,
                                                      idMPersona);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return MPersona;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection personas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            personas = HibernateUtil.getSession()
                                    .createCriteria(MPersona.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return personas;
    }


    public Collection buscarPorEjemplo(MPersona MPersona)
            throws ExcepcionInfraestructura {


        Collection personas;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(MPersona.class);
            personas = criteria.add(Example.create(MPersona)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return personas;
    }


    public void hazPersistente(MPersona MPersona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(MPersona)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(MPersona);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(MPersona MPersona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(MPersona)");
        }

        try {
            HibernateUtil.getSession().delete(MPersona);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeMPersona(String nombreMPersona)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
			
			
//            String consultaCuentaRoles =
//            "select count(*) from MPersona r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			String hql = "select Nombre from MPersona where Nombre = :Nombre";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + nombreMPersona);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("Nombres", nombreMPersona);
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
    public Collection ordenarPor(String tipo, int tipoInt)
            throws ExcepcionInfraestructura {

        Collection ciudades;

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }
        String add="";
        if (tipoInt==0) {
            add="ASC";
        } else if(tipoInt==1) {
            add="DESC";
        }
        try {
            String hql="from MPersona";
            if(tipo.equals("nombre")) {
                hql = "from MPersona order by Nombre "+add;
            } else if(tipo.equals("ap_paterno")) {
                hql = "from MPersona order by ap_paterno "+add;
            }else if(tipo.equals("ap_materno")) {
                hql = "from MPersona order by ap_materno "+add;
            } else if(tipo.equals("direccion")) {
                hql = "from MPersona order by Direccion "+add;
            } else if(tipo.equals("telefono")) {
                hql = "from MPersona order by Telefono "+add;
            } else if(tipo.equals("ciudad")) {
                hql = "from MPersona order by idCiudad "+add;
            } 
            
             if (log.isDebugEnabled()) {
                 log.debug(hql);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            ciudades = query.list();

            return ciudades;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
