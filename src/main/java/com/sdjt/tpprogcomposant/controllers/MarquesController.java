package com.sdjt.tpprogcomposant.controllers;

import com.sdjt.tpprogcomposant.models.Concessionnaire;
import com.sdjt.tpprogcomposant.models.Marque;
import com.sdjt.tpprogcomposant.repositories.ConcessionnaireRepository;
import com.sdjt.tpprogcomposant.repositories.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v0/marques")
public class MarquesController {
    @Autowired
    private MarqueRepository marqueRepository;

    @GetMapping
    public List<Marque> list() {
        return marqueRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Marque get(@PathVariable int id) {
        return marqueRepository.getOne(id);
    }

    /*@PostMapping
    public Marque create(@RequestBody final Marque marque) {
        return marqueRepository.saveAndFlush(marque);
    }*/
}
