package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de un section
 *
 * @author Mauri Agueda,angyay0
 */
public final class FormaListadoSections
        extends ValidatorForm {

    private Collection sections;
    private int contador;


    public void setSections(Collection sections) {
        this.sections = sections;
        if (sections != null) {
          this.contador = sections.size();
        } else
          this.contador = -1;
    }

    public Collection getSections() {
        return (this.sections);
    }
  
    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        sections=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }
}
