package com.sdjt.tpprogcomposant.controllers;

import com.sdjt.tpprogcomposant.models.Voiture;
import com.sdjt.tpprogcomposant.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/api/v0/voitures")
public class VoituresController {
    @Autowired
    private VoitureRepository voitureRepository;

    @GetMapping
    public List<Voiture> list() {
        return voitureRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Voiture get(@PathVariable int id) {
        return voitureRepository.getOne(id);
    }

    /*@PostMapping
    public Voiture create(@RequestBody final Voiture voiture) {
        return voitureRepository.saveAndFlush(voiture);
    }*/
}
