package edu.uag.iidis.scec.modelo;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase es usada para representar a una MPersona. 
 *
 * <p>
 * <a href="MPersona.java.html"><i>Ver código fuente</i></a>
 * </p>
 *
 * @author <a href="mailto:angyay0@gmail.com">Angel Perez</a>
 * @version 1.0
 */
public class Gente {
    
    protected Long id;
    protected Long idCiudad;
    protected String nombres;
    protected String apellidos;
    protected String direccion;
    protected String telefono;
    protected Long idRol;


    public Gente(){
    }

    public Gente(String nombre,String apellidos,String dir,String tel,Long idCiudad) {
        this.nombres=nombre;
        this.apellidos=apellidos;
        this.direccion = dir;
        this.telefono = tel;
        this.idCiudad = idCiudad;
    }

    public Gente(String nombre,String apellidos,String dir,String tel,Long idCiudad,Long id) {
        this.nombres=nombre;
        this.apellidos=apellidos;
        this.direccion = dir;
        this.telefono = tel;
        this.idCiudad = idCiudad;
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getidCiudad() {
        return idCiudad;
    }

    public void setidCiudad(Long id) {
        this.idCiudad = id;
    }
   
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String app) {
        this.apellidos = app;
    }
    
    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String dir) {
        this.direccion = dir;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String tel) {
        this.telefono = tel;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long id) {
        this.idRol = id;
    }

}
