package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import java.util.Collection;
import java.util.List;

/**
 * Form bean para el registro de una nueva persona.
 *
 *
 */
public final class FormaProcesarRespuestas
        extends ValidatorForm {

    private Long idTest;
    private List selected;
    
    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public Long getIdTest() {
        return (this.idTest);
    }

    public void setSelected(List l) {
        this.selected = l;
    }

    public List getSelected() {
        return (this.selected);
    }

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        idTest = null;
        selected = org.apache.commons.collections.ListUtils.lazyList(new java.util.ArrayList(), new org.apache.commons.collections.Factory() {
               public Object create() { return new Dataline(); }
          });
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

    public class Dataline {

        private String line;

        public Dataline(){}

        public Dataline(String line){
            this.line = line;
        }
        
        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

    }
}
