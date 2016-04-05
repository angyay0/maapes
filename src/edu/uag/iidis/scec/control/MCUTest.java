package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.TestSectionDAO;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

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



public final class MCUTest 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCUTest.class);

	//Listar Tests
    public ActionForward solicitarTest(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarVerTest");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaVerTest forma = (FormaVerTest)form;

        ManejadorSections ms = new ManejadorSections();
        ManejadorQuestions mq = new ManejadorQuestions();
        ManejadorAnswers ma = new ManejadorAnswers();
        ManejadorTestSection ts = new ManejadorTestSection();
        
		HashMap<Section,HashMap> sections = new HashMap<Section, HashMap>();
		Collection testSec = ts.listarByTest(forma.getId());

		HashMap<Question,Collection> quesAns = null; 
		Collection quest = null;
		Collection answ = null;
		
		TestSection tso = null;
		Section sec = null;
		Question question = null;
	int i  =0;
		try{
			for(Iterator<TestSection> it = testSec.iterator(); it.hasNext(); ) {
				tso = (TestSection) it.next();
				quest = mq.listarBySection( tso.getIdSection() );
				quesAns = new HashMap<Question,Collection>();

				synchronized(quest){
					for(Iterator<Question> it2 = quest.iterator(); it2.hasNext(); ) {
						question = (Question) it2.next();
						System.out.println("Pregunta num: "+question.getId());
						answ = ma.listarByQuestion( question.getId() );
						quesAns.put( question, answ );
					
					}
				}
				System.out.println("incremento: "+i);
				sec = (Section) ms.obtenerSection( tso.getIdSection() );
				sections.put( sec, quesAns );
				i++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
        
        ActionMessages errores = new ActionMessages();
        if (sections != null) {
            if ( sections.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setSections( sections );
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

    public ActionForward procesarRespuestas(
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

        FormaProcesarRespuestas forma = (FormaProcesarRespuestas) form;
        System.out.println("Huelelelele FormaProcesarRespuestas");

        Gente user = (Gente) request.getSession().getAttribute("user");
        System.out.println("Huelelelele Gente");

        ManejadorTry mt = new ManejadorTry();
        System.out.println("Huelelelele ManejadorTry");

        ManejadorUserAnswer mua = new ManejadorUserAnswer();
        System.out.println("Huelelelele ManejadorUserAnswer");

        System.out.println("Datos try "+forma.getIdTest()+" "+user.getId());
        Try myTry = new Try(forma.getIdTest(), user.getId());
        System.out.println("Huelelelele Try");

        int resultado = mt.crearTry(myTry);
        System.out.println("Huelelelele resultado "+String.valueOf(resultado));

        System.out.println("Tamaño "+forma.getSelected().size());
            for(Object s : forma.getSelected()){
                if(s != null){
                    FormaProcesarRespuestas.Dataline d = (FormaProcesarRespuestas.Dataline)s;
                    System.out.println("Huelelelele "+d.getLine());
                    UserAnswer ans = new UserAnswer(myTry.getId(),Long.parseLong(d.getLine()));
                    resultado += mua.crearUserAnswer(ans);
                }
            }
        

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
                            new ActionMessage("errors.idTryYaExiste",
                                               myTry.getId()));                
                saveErrors(request, errores);
                return (mapping.findForward("cancelar"));
                //return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.findForward("cancelar"));
                //return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.findForward("cancelar"));
                //return (mapping.getInputForward());
        }
    }


}
