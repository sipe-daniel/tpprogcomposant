package com.sdjt.tpprogcomposant.controllers;

import com.sdjt.tpprogcomposant.models.Concessionnaire;
import com.sdjt.tpprogcomposant.repositories.ConcessionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v0/concessionnaires")
public class ConcessionnairesController {
    @Autowired
    private ConcessionnaireRepository concessionnaireRepository;

    @GetMapping
    public List<Concessionnaire> list() {
        return concessionnaireRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Concessionnaire get(@PathVariable int id) {
        return concessionnaireRepository.getOne(id);
    }

    /*@PostMapping
    public Concessionnaire create(@RequestBody final Concessionnaire concessionnaire) {
        return concessionnaireRepository.saveAndFlush(concessionnaire);
    }*/
}
