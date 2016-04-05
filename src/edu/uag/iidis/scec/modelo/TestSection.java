package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;




public class TestSection extends ClaseBase
        implements Serializable {

    private Long idTest;
    private Long id;
	private Long idSection;
	
    public TestSection() {
    }

    public TestSection(Long idTest,Long idSection){
        this.idTest = idTest;
        this.idSection = idSection;
    }

    public TestSection(Long idTest,Long idSection,Long id){
        this.idTest = idTest;
        this.idSection = idSection;
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

    public Long getIdSection() {
        return this.idSection;
    }

    public void setIdSection(Long id) {
        this.idSection = id;
    }

}
