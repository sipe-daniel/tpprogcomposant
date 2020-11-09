package com.sdjt.tpprogcomposant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "concessionnaires")
public class Concessionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_concessionnaire;
    private String nom_concessionnaire;

    public Concessionnaire() {
    }

    public Concessionnaire(int id_concessionnaire, String nom) {
        this.id_concessionnaire = id_concessionnaire;
        this.nom_concessionnaire = nom;
    }

    public int getId_concessionnaire() {
        return id_concessionnaire;
    }

    public void setId_concessionnaire(int id_concessionnaire) {
        this.id_concessionnaire = id_concessionnaire;
    }

    public String getNom() {
        return nom_concessionnaire;
    }

    public void setNom(String nom) {
        this.nom_concessionnaire = nom;
    }
}
