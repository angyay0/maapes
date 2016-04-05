package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario. 
 *
 * <p><a href="Estado.java.html"><i>Ver c�digo fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Estado extends ClaseBase 
        implements Serializable {

    private Long id;
    private String nombre;
    private List usuarios = new ArrayList();

    public Estado() {
    }

    public Estado(Long id){
        this.id = id;
    }

    public Estado(String nombre){
        this.nombre=nombre;
    }

    public Estado(String nombre,Long id){
        this.nombre=nombre;
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

    /**
     * Regresa los usuarios del rol.
     * @return List
     */
    public List getUsuarios() {
        return this.usuarios;
    }

    /**
     * Establece los usuarios del rol.
     * @return void
     */
    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        usuario.getEstados().add(this);
    }
}
