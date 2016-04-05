package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;




public class Section extends ClaseBase 
        implements Serializable {

    private Long id;
    private String title;

    public Section() {
    }

    public Section(Long id){
        this.id = id;
    }

    public Section(String title){
        this.title=title;
    }

    public Section(String title,Long id){
        this.title=title;
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


    /**
     * Regresa el nombre del rol.
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Establece el nombre del rol.
     * @return void
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
