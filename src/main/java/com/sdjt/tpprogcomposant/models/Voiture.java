package com.sdjt.tpprogcomposant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "voitures")
public class Voiture {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_voiture;
    private String nom_voiture;

    public Voiture() {
    }

    public Voiture(int id_voiture, String nom_voiture) {
        this.id_voiture = id_voiture;
        this.nom_voiture = nom_voiture;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getNom_voiture() {
        return nom_voiture;
    }

    public void setNom_voiture(String nom_voiture) {
        this.nom_voiture = nom_voiture;
    }
}
