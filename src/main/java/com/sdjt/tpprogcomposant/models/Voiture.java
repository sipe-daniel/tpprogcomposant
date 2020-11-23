package com.sdjt.tpprogcomposant.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "voitures")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Voiture {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id_voiture;

    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "id_marque"))
    private Marque marque;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "id_client"))
    private Client client;


    public Voiture() {}

    public Voiture(int id_voiture, String name) {
        this.id_voiture = id_voiture;
        this.name = name;
    }


}
