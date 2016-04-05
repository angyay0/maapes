package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

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



public final class MCURegistrarEstado 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarRegistroEstado(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroEstado");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward solicitarModificarEstado(/******/
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarModificarEstado");
        }

        return (mapping.findForward("exito"));
    }



    public ActionForward procesarRegistroEstado(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroEstado");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        String volver = request.getParameter("volver");

        
        // Se obtienen los datos para procesar el registro
        FormaNuevoEstado forma = (FormaNuevoEstado)form;

        Estado rol = new Estado(forma.getNombre());

        ManejadorEstados mr = new ManejadorEstados();
        int resultado = mr.crearEstado(rol);

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
                            new ActionMessage("errors.nombreEstadoYaExiste",
                                               forma.getNombre()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurri� un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regres� reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

    public ActionForward procesarModificarEstado(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarModificarEstado");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        String volver = request.getParameter("volver");

        
        // Se obtienen los datos para procesar el registro
        FormaModificarEstado forma = (FormaModificarEstado)form;

        Estado rol = new Estado(forma.getNombre(),forma.getId());

        ManejadorEstados mr = new ManejadorEstados();
        int resultado = mr.modificarEstado(rol);

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
                            new ActionMessage("errors.nombreEstadoYaExiste",
                                               forma.getNombre()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurri� un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regres� reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}

