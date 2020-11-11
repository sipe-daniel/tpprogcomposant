package com.sdjt.tpprogcomposant.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "adresses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_adresse;
    private String ville_adresse;
    private String pays;
    private String numero_de_tel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "id_concessionnaire"), name = "id_concessionnaire")
    private Concessionnaire concessionnaire;

    public Adresse() {
    }

    public Adresse(int id_adresse, String ville_adresse, String pays, String numero_de_tel) {
        this.id_adresse = id_adresse;
        this.ville_adresse = ville_adresse;
        this.pays = pays;
        this.numero_de_tel = numero_de_tel;
    }

    public Concessionnaire getConcessionnaire() {
        return concessionnaire;
    }

    public void setConcessionnaire(Concessionnaire concessionnaire) {
        this.concessionnaire = concessionnaire;
    }

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getVille_adresse() {
        return ville_adresse;
    }

    public void setVille_adresse(String ville_adresse) {
        this.ville_adresse = ville_adresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNumero_de_tel() {
        return numero_de_tel;
    }

    public void setNumero_de_tel(String numero_de_tel) {
        this.numero_de_tel = numero_de_tel;
    }

}
