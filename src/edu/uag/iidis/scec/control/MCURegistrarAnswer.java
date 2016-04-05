package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
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



public final class MCURegistrarAnswer 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward solicitarRegistroAnswer(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {


        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroAnswer");
        }

        return (mapping.findForward("exito"));
    }

	public ActionForward solicitarModificarAnswer(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {
/*
		FormaModificarAnswer forma = (FormaModificarAnswer)form;

        ManejadorAnswers mr = new ManejadorAnswers();
        Answer q = mr.buscarAnswer(forma.getId());

        forma.setData( q );
  */      
        if (log.isDebugEnabled()) {
            log.debug(">solicitarModificarAnswer");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward procesarRegistroAnswer(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroAnswer");
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
        FormaNuevoAnswer forma = (FormaNuevoAnswer)form;

        Answer rol = new Answer(forma.getText(), forma.getIdQuestion(),forma.getRgt());

        ManejadorAnswers mr = new ManejadorAnswers();
        int resultado = mr.crearAnswer(rol);

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
                            new ActionMessage("errors.textoAnswerYaExiste",
                                               forma.getText()));                
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

	public ActionForward procesarModificarAnswer(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroAnswer");
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
        FormaModificarAnswer forma = (FormaModificarAnswer)form;

        Answer rol = new Answer(forma.getText(), forma.getIdQuestion(), forma.getId(),forma.getRgt());

        ManejadorAnswers mr = new ManejadorAnswers();

        
        if(forma.getRgt() == 1){

            Collection col = mr.listarByQuestion(forma.getIdQuestion());

            for(Object o : col){
                Answer a = (Answer)o;
                a.setRgt(new Long("0"));
                mr.modificarAnswer(a);
            }
        }

        int resultado = mr.modificarAnswer(rol);

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
                            new ActionMessage("errors.textoAnswerYaExiste",
                                               forma.getText()));                
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

