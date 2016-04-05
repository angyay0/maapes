package edu.uag.iidis.scec.vista;

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
public final class FormaNuevoQuestion
        extends ValidatorForm {

    private String text;
    private Long idSection;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return (this.text);
    }

    public void setIdSection(Long idSection) {
        this.idSection = idSection;
    }

    public Long getIdSection() {
        return (this.idSection);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        text=null;
        idSection=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
