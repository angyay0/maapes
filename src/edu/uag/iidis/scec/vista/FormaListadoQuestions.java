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
public final class FormaListadoQuestions
        extends ValidatorForm {

    private Collection questions;
    private long idSection;
    private int contador;

    public void setQuestions(Collection questions) {
        this.questions = questions;
        if (questions != null) {
          this.contador = questions.size();
        } else
          this.contador = -1;
    }

    public Collection getQuestions() {
        return (this.questions);
    }
  
    public int getContador() {
        return (this.contador);
    }

    public void setIdSection(long idSection){
        this.idSection = idSection;
    }

    public long getIdSection(){
        return (this.idSection);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        questions=null;
        idSection=0;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
