package edu.uag.iidis.scec.vista;

import edu.uag.iidis.scec.modelo.Question;

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
public final class FormaModificarQuestion
        extends ValidatorForm {

	private Long id;
    private String text;
    private Long idSection;
	
    public void setText(String text) {
        this.text = text;
    }

    public void setData(Question q){
    	if( q != null ) { 
			this.id = q.getId();
			this.text = q.getText();
			this.idSection = q.getidSection();
		}
    }

    public String getText() {
        return (this.text);
    }

    public void setIdSection(Long id) {
        this.idSection = id;
    }

    public Long getIdSection() {
        return (this.idSection);
    }

     public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return (this.id);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        text=null;
        idSection=null;
        id=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
