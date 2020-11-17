package com.sdjt.tpprogcomposant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "concessionnaires")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Concessionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_concessionnaire;
    private String name;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="concessionnaire")
    @JsonIgnore
    private List<Adresse> adresses;


    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "concessionnaires")
    @JsonIgnore
    private List<Marque> marques;

    public Concessionnaire() {
    }

    public Concessionnaire(int id_concessionnaire, String name) {
        this.id_concessionnaire = id_concessionnaire;
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Adresse> getAdresses() { return adresses; }

    public void setAdresses(List<Adresse> adresses) { this.adresses = adresses; }

    public List<Marque> getMarques() { return marques; }

    public void setMarques(List<Marque> marques) { this.marques = marques; }



    public int getId_concessionnaire() {
        return id_concessionnaire;
    }

    public void setId_concessionnaire(int id_concessionnaire) {
        this.id_concessionnaire = id_concessionnaire;
    }


}
