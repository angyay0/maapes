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
 *
 */
public final class FormaNuevoTest
        extends ValidatorForm {

    private String title;
    private Collection sections;
    private String[] selected;
    private int contador;

    public void setSections(Collection sections){
        this.sections = sections;
        if( sections != null ){
            this.contador = sections.size();
        }else{
            this.contador = -1;
        }
    }

    public Collection getSections(){
        return (this.sections);
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return (this.title);
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
        sections = null;
        contador = 0;
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
