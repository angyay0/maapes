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
public final class FormaNuevoAnswer
        extends ValidatorForm {

    private String text;
    private Long idQuestion;
    private Long rgt;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return (this.text);
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Long getIdQuestion() {
        return (this.idQuestion);
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
