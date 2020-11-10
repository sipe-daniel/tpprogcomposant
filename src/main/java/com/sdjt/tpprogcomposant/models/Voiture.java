package com.sdjt.tpprogcomposant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity(name = "voitures")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Voiture {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_voiture;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private Marque marque;

    public Voiture() { }

    public Voiture(int id_voiture, String name) {
        this.id_voiture = id_voiture;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }


}
