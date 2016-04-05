package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
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



public final class MCURegistrarTest
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarTest.class);


    public ActionForward solicitarRegistroTest(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

		FormaNuevoTest forma = (FormaNuevoTest) form;
		ManejadorSections mr = new ManejadorSections();
		Collection resultado = mr.listarSections();
		forma.setSections( resultado );
				
        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroTest");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward procesarRegistroTest(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroTest");
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
        FormaNuevoTest forma = (FormaNuevoTest)form;
        ManejadorTestSection mts = new ManejadorTestSection();
		//System.out.println( "Sizeeeee:==> "+forma.getSelected().length );
		
        Test rol = new Test(forma.getTitle());
/*
        rol.setSections(sections);
*/
        ManejadorTests mr = new ManejadorTests();
        int resultado = mr.crearTest(rol);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
            	Test just = mr.buscarByName(forma.getTitle());
            	if( forma.getSelected() != null && just != null) {
					for(String s: forma.getSelected() ){
						mts.crearTestSection( new TestSection(just.getId(),Long.valueOf(s) ) );
					}
				}   
                if(volver != null && volver.equals("si")){
                    return (mapping.findForward("volver"));
                }else{
                    return (mapping.findForward("exito"));
                }

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreTitleYaExiste",
                                               forma.getTitle()));                
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

//Modificar Test
	 public ActionForward solicitarModificarTest(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

		FormaModificarTest forma = (FormaModificarTest) form;
		ManejadorSections mr = new ManejadorSections();
		ManejadorTestSection mt = new ManejadorTestSection();

		HashMap<String, Section> sections = new HashMap<String, Section>(); 
		Collection owned = null;
		Collection res = mr.listarSections();
		Section sec = null;
		TestSection tso = null;
		int i ;
		int c = 0;
		try{
			for(Iterator<Section> it = res.iterator(); it.hasNext(); ) {
				sec = (Section) it.next();
				owned = mt.listarByTest( forma.getId() );
				i = 0;
				synchronized(owned){
					for(Iterator<TestSection> it2 = owned.iterator(); it2.hasNext(); ) {
						tso = (TestSection) it2.next();
						if( tso.getIdSection() == sec.getId() ){
							sections.put( "1-"+String.valueOf(c),sec );
							i = 1;
							break;
						}
					}

					if( i == 0 ){
						sections.put( "0-"+String.valueOf(c), sec );
					}

					c++;
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("System Salio: "+sections.size());
		System.out.println("System Salio: "+res.size());
		System.out.println("System Salio: "+owned.size());
		forma.setSections( sections );
		
        if (log.isDebugEnabled()) {
            log.debug(">solicitarModificarTest");
        }

        return (mapping.findForward("exito"));
    }

    public ActionForward procesarModificarTest(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarModificarTest");
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
        FormaModificarTest forma = (FormaModificarTest)form;
		ManejadorTestSection mts = new ManejadorTestSection();
		//System.out.println( "Sizeeeee:==> "+forma.getSelected().length );
		if( forma.getSelected() != null) {
			for(String s: forma.getSelected() ){
				mts.crearTestSection( new TestSection(forma.getId(),Long.valueOf(s) ) );
			}
		}
			
        Test rol = new Test(forma.getTitle(),forma.getId());
		System.out.println("MIRA VERA: "+forma.getTitle()+"-"+forma.getId());
        ManejadorTests mr = new ManejadorTests();
        int resultado = mr.modificarTest(rol);

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
                            new ActionMessage("errors.nombreTestYaExiste",
                                               forma.getTitle()));                
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

