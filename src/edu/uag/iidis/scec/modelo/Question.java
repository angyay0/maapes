package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Question.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Question extends ClaseBase 
        implements Serializable {

    private Long id;
    private Long idSection;
    private String text;


    public Question() {
    }

    public Question(Long id){
        this.id = id;
    }

    public Question(String text, Long idSection){
        this.text=text;
        this.idSection=idSection;
    }

    public Question(String text, Long idSection,Long id){
        this.text=text;
        this.idSection=idSection;
        this.id = id;
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del rol.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getidSection() {
        return this.idSection;
    }

    public void setidSection(Long id) {
        this.idSection = id;
    }
    /**
     * Regresa el text del rol.
     * @return String
     */
    public String getText() {
        return this.text;
    }

    /**
     * Establece el text del rol.
     * @return void
     */
    public void setText(String text) {
        this.text = text;
    }

}
