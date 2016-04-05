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
public class MPersona {
    
    protected Long id;
    protected Long idCiudad;
    protected String nombre;
    protected String ap_paterno;
    protected String ap_materno;
    protected String direccion;
    protected String telefono;


    public MPersona(){
    }

    public MPersona(String nombre,String app,String apm,String dir,
    				String tel,Long idCiudad) {
        this.nombre=nombre;
        this.ap_paterno = app;
        this.ap_materno = apm;
        this.direccion = dir;
        this.telefono = tel;
        this.idCiudad = idCiudad;
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
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getap_Paterno() {
        return ap_paterno;
    }

    public void setap_Paterno(String app) {
        this.ap_paterno = app;
    }

    public String getap_Materno() {
        return ap_materno;
    }

    public void setap_Materno(String apm) {
        this.ap_materno = apm;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String dir) {
        this.direccion = dir;
    }

    public String gettelefono() {
        return telefono;
    }

    public void settelefono(String tel) {
        this.telefono = tel;
    }

}
