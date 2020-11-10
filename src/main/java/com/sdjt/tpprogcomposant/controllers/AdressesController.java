package com.sdjt.tpprogcomposant.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sdjt.tpprogcomposant.models.Adresse;
import com.sdjt.tpprogcomposant.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v0/adresses")
public class AdressesController {
    @Autowired
    private AdresseRepository adresseRepository;

    @GetMapping
    public List<Adresse> list() {
        return adresseRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Adresse get(@PathVariable int id) {
        return adresseRepository.getOne(id);
    }

    /*@PostMapping
    public Adresse create(@RequestBody final Adresse adresse) {
        return adresseRepository.saveAndFlush(adresse);
    }*/
}
