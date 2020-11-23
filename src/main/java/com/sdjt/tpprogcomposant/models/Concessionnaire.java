package com.sdjt.tpprogcomposant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "concessionnaires")
@Data
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



}
