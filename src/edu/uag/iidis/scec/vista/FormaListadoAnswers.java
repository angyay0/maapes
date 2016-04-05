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
public final class FormaListadoAnswers
        extends ValidatorForm {

    private Collection answers;
    private long idQuestion;
    private int contador;

    public void setAnswers(Collection answers) {
        this.answers = answers;
        if (answers != null) {
          this.contador = answers.size();
        } else
          this.contador = -1;
    }

    public Collection getAnswers() {
        return (this.answers);
    }
  
    public int getContador() {
        return (this.contador);
    }

    public void setIdQuestion(long idQuestion){
        this.idQuestion = idQuestion;
    }

    public long getIdQuestion(){
        return (this.idQuestion);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        answers=null;
        idQuestion=0;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
