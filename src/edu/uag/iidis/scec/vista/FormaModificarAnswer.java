package edu.uag.iidis.scec.vista;

import edu.uag.iidis.scec.modelo.Answer;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaModificarAnswer
        extends ValidatorForm {

	private Long id;
    private String text;
    private Long idQuestion;
    private Long rgt;
	
    public void setText(String text) {
        this.text = text;
    }

    public void setData(Answer a){
    	if( a != null ) { 
			this.id = a.getId();
			this.text = a.getText();
			this.idQuestion = a.getidQuestion();
			this.rgt = a.getRgt();
		}
    }

    public String getText() {
        return (this.text);
    }

    public void setIdQuestion(Long id) {
        this.idQuestion = id;
    }

    public Long getIdQuestion() {
        return (this.idQuestion);
    }

     public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return (this.id);
    }

    public void setRgt(Long rgt) {
        this.rgt = rgt;
    }

    public Long getRgt() {
        return (this.rgt);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        text = null;
        idQuestion = null;
        id = null;
        rgt = null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
