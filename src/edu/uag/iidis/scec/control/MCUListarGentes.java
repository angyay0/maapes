package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
import java.util.ArrayList;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;



public final class MCUListarGentes 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarListarGentes(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarGentes");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoGentes forma = (FormaListadoGentes)form;

        ManejadorGentes mr = new ManejadorGentes();
        Collection resultado = mr.listarGentes();

        ManejadorCiudades mr2 = new ManejadorCiudades();
        Collection resultado2 = mr2.listarCiudades();

        forma.setCiudades( resultado2 );

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setGentes( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }

    public ActionForward solicitarReporte(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarReporte");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaReporte forma = (FormaReporte)form;

        ManejadorGentes mr = new ManejadorGentes();
        Collection resultado = mr.listarGentes();

        ManejadorCiudades mr2 = new ManejadorCiudades();
        Collection resultado2 = mr2.listarCiudades();

        forma.setCiudades( resultado2 );

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setGentes( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }

    public ActionForward solicitarOrdNombres(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaListadoGentesOrdenar forma = (FormaListadoGentesOrdenar)form;

        ManejadorGentes mr = new ManejadorGentes();

        if (log.isDebugEnabled()) {
            log.debug(">var1: "+forma.getOrdenar()+" >var2: "+forma.getTipo());
        }

        response.setContentType("text/text;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        PrintWriter out = response.getWriter();

        Collection resultado = mr.listarGentesOrd(forma.getOrdenar(), forma.getTipo());

        ManejadorCiudades mr2 = new ManejadorCiudades();
        Collection resultado2 = mr2.listarCiudades();

        //forma.setCiudades( resultado2 );

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                //forma.setGentes( resultado );
                ArrayList<String> resp = new ArrayList(); 
                for(Object g : resultado){
                    for(Object c : resultado2){
                        Gente gen = (Gente)g;
                        Ciudad ciu = (Ciudad)c;
                        if( gen.getidCiudad() == ciu.getId() ){
                            resp.add( "{\"nombres\":\""+gen.getNombres()+"\", \"apellidos\":\""+gen.getApellidos()+"\","+
                                        "\"direccion\":\""+gen.getdireccion()+"\", \"telefono\":\""+gen.getTelefono()+"\","+
                                        "\"ciudad\":\""+ciu.getNombre()+"\"}");
                        }
                    }
                }
                out.print("[");
                if(!resp.isEmpty()){
                    out.print(resp.get(0));
                    resp.remove(0);
                }
                for(String s : resp){
                    out.print(","+s);
                }
                out.print("]");

                out.flush();
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }
}
