package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Answer.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Answer extends ClaseBase 
        implements Serializable {

    private Long id;
    private Long idQuestion;
    private Long rgt;
    private String text;


    public Answer() {
    }

    public Answer(Long id){
        this.id = id;
    }

    public Answer(String text, Long idQuestion, Long rgt){
        this.text=text;
        this.idQuestion=idQuestion;
        this.rgt = rgt;
    }

    public Answer(String text, Long idQuestion,Long id,Long rgt){
        this.text=text;
        this.idQuestion=idQuestion;
        this.id = id;
        this.rgt = rgt;
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

    public Long getidQuestion() {
        return this.idQuestion;
    }

    public void setidQuestion(Long id) {
        this.idQuestion = id;
    }

    public Long getRgt() {
        return this.rgt;
    }

    public void setRgt(Long rgt) {
        this.rgt = rgt;
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
