package com.sdjt.tpprogcomposant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "marques")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_marque;
    private String nom_marque;

    public Marque() {
    }

    public Marque(int id_marque, String nom) {
        this.id_marque = id_marque;
        this.nom_marque = nom;
    }

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    public String getNom() {
        return nom_marque;
    }

    public void setNom(String nom) {
        this.nom_marque = nom;
    }
}
