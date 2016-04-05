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



public final class MCURegistrarGente 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarRegistroGente(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevoGente forma = (FormaNuevoGente)form;

        ManejadorCiudades mr = new ManejadorCiudades();
        Collection resultado = mr.listarCiudades();

        forma.setCiudades( resultado );

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroGente");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward solicitarModificarGente(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaModificarGente forma = (FormaModificarGente)form;

        ManejadorCiudades mr = new ManejadorCiudades();
        Collection resultado = mr.listarCiudades();

        forma.setCiudades( resultado );

        if (log.isDebugEnabled()) {
            log.debug(">solicitarModificarGente");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward solicitarRegistroGenteCiudades(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        FormaNuevoGenteCiudades forma = (FormaNuevoGenteCiudades)form;

        ManejadorCiudades mr = new ManejadorCiudades();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroGenteCiudades: buscando:"+forma.getciudadBuscar());
        }

        response.setContentType("text/text;charset=utf-8");
        response.setHeader("cache-control", "no-cache");
        PrintWriter out = response.getWriter();

        Collection resultado = mr.buscarCiudades(forma.getciudadBuscar());

        //forma.setCiudades( resultado );

        ManejadorEstados mr2 = new ManejadorEstados();
        Collection resultado2 = mr2.listarEstados();

        //forma.setEstados( resultado2 );

        ArrayList<String> resp = new ArrayList(); 
        for(Object c : resultado){
            for(Object e : resultado2){
                Ciudad ciu = (Ciudad)c;
                Estado es = (Estado)e;
                if( ciu.getidEstado() == es.getId() ){
                    resp.add( "{\"ciudad\":\""+ciu.getNombre()+"\", \"idCiudad\":\""+ciu.getId()+"\","+
                                "\"estado\":\""+es.getNombre()+"\", \"idEstado\":\""+es.getId()+"\"}");
                }
            }
        }

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroGenteCiudades");
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

        return (mapping.findForward("exito"));
    }


    public ActionForward procesarRegistroGente(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroGente");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        String volver = request.getParameter("volver");

        
        // Se obtienen los datos para procesar el registro
        FormaNuevoGente forma = (FormaNuevoGente)form;
		Gente rol = new Gente(forma.getNombres(),
                          forma.getApellidos(), forma.getDireccion(), forma.getTelefono(), forma.getidCiudad());

        ManejadorGentes mr = new ManejadorGentes();
        int resultado = mr.crearGente(rol);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:   
                if(volver != null && volver.equals("si")){
                    return (mapping.findForward("volver"));
                }else{
                    return (mapping.findForward("exito"));
                }

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreGenteYaExiste",
                                               forma.getNombres()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

     public ActionForward procesarModificarGente(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarModificarGente");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        String volver = request.getParameter("volver");

        
        // Se obtienen los datos para procesar el registro
        FormaModificarGente forma = (FormaModificarGente)form;
		Gente rol = new Gente(forma.getNombres(),
                          forma.getApellidos(), forma.getDireccion(), forma.getTelefono(), forma.getidCiudad(),forma.getId());

        ManejadorGentes mr = new ManejadorGentes();
        int resultado = mr.modificarGente(rol);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:   
                if(volver != null && volver.equals("si")){
                    return (mapping.findForward("volver"));
                }else{
                    return (mapping.findForward("exito"));
                }

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreGenteYaExiste",
                                               forma.getNombres()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}

