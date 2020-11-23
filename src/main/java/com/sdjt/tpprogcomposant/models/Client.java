package com.sdjt.tpprogcomposant.models;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "clients")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_client;
    private String name;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="client")
    @JsonIgnore
    private List<Voiture> voitures;

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public Client(){}

    public Client(int id_client, String name) {
        this.id_client = id_client;
        this.name = name;
    }



}
