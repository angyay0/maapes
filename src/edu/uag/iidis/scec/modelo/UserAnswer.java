package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;




public class UserAnswer extends ClaseBase
        implements Serializable {

    private Long id;
    private Long idTry;
	private Long idAnswer;
	
    public UserAnswer() {
    }

    public UserAnswer(Long idTry,Long idAnswer){
        this.idTry = idTry;
        this.idAnswer = idAnswer;
    }

    public Long getIdTry() {
        return this.idTry;
    }

    public void setIdTry(Long id) {
        this.idTry = id;
    }

    public Long getIdAnswer() {
        return this.idAnswer;
    }

    public void setIdAnswer(Long id) {
        this.idAnswer = id;
    }

    public Long getId(){    
        return this.id;  
    }
    public void setId(long id){ this.id = id;   }

}
