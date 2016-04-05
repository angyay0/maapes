package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import edu.uag.iidis.scec.modelo.*;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaModificarTest
        extends ValidatorForm {

	private Long id;
    private String title;
    private HashMap sections;
    private String[] selected;
    private int contador;

    public void setSections(HashMap sections){
		this.sections = sections;
		if( sections != null ){
			this.contador = sections.size();
		}else{
			this.contador = -1;
		}
    }

    public HashMap getSections(){
		return (this.sections);
    }

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

     public void setSelected(String[] s) {
        this.selected = s;
    }

    public String[] getSelected() {
        return (this.selected);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        title=null;
        id = null;
        sections = null;
        selected = null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
