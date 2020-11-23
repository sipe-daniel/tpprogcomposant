package com.sdjt.tpprogcomposant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "adresses")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_adresse;
    private String adresse_ville;
    private String pays;
    private String telephone;


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "id_concessionnaire"))
    private Concessionnaire concessionnaire;

    public Adresse() {
    }





}
