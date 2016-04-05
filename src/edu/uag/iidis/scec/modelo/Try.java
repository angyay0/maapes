package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;




public class Try extends ClaseBase
        implements Serializable {

    private Long idTest;
    private Long id;
	private Long idUser;
	
    public Try() {
    }

    public Try(Long idTest,Long idUser){
        this.idTest = idTest;
        this.idUser = idUser;
    }

    public Try(Long idTest,Long idUser,Long id){
        this.idTest = idTest;
        this.idUser = idUser;
        this.id = id;
    }

    public Long getIdTest() {
        return this.idTest;
    }

    public void setIdTest(Long id) {
        this.idTest = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long id) {
        this.idUser = id;
    }

}
