package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import java.util.Collection;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaModificarSection
        extends ValidatorForm {

	private Long id;
    private String title;
    private Collection questions;
    private int contador;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return (this.title);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return (this.id);
    }

    public Collection getQuestions(){
        return (this.questions);
    }

    public void setQuestions(Collection questions){
        this.questions = questions;
        if( questions != null ){
            this.contador = questions.size();
        }else{
            this.contador = -1;
        }
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        title=null;
        id = null;
        questions = null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
