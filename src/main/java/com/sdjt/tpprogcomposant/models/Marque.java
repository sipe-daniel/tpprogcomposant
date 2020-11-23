package com.sdjt.tpprogcomposant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "marques")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_marque;
    private String name;


    @OneToMany(fetch=FetchType.LAZY, mappedBy="marque")
    @JsonIgnore
    private List<Voiture> voitures;

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name = "concessionnaires_marques_junction",
            joinColumns = @JoinColumn(name = "id_concessionnaire"),
            inverseJoinColumns = @JoinColumn(name = "id_marque"))
    @JsonIgnore
    private List<Concessionnaire> concessionnaires;



    public Marque() {
    }

    public Marque(int id_marque, String name) {
        this.id_marque = id_marque;
        this.name = name;
    }



}
