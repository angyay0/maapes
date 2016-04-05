package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Ciudad.java.html"><i>Ver c�digo fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Ciudad extends ClaseBase 
        implements Serializable {

    private Long id;
    private Long idEstado;
    private String nombre;


    public Ciudad() {
    }

    public Ciudad(Long id){
        this.id = id;
    }

    public Ciudad(String nombre, Long idEstado){
        this.nombre=nombre;
        this.idEstado=idEstado;
    }

    public Ciudad(String nombre, Long idEstado,Long id){
        this.nombre=nombre;
        this.idEstado=idEstado;
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

    public Long getidEstado() {
        return this.idEstado;
    }

    public void setidEstado(Long id) {
        this.idEstado = id;
    }
    /**
     * Regresa el nombre del rol.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del rol.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
