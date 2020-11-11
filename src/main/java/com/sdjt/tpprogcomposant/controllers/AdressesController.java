package com.sdjt.tpprogcomposant.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sdjt.tpprogcomposant.models.Adresse;
import com.sdjt.tpprogcomposant.models.Concessionnaire;
import com.sdjt.tpprogcomposant.repositories.AdresseRepository;
import org.springframework.beans.BeanUtils;
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

    @PostMapping
    public Adresse create(@RequestBody Adresse adresse) {
        return adresseRepository.saveAndFlush(adresse);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id) {
        adresseRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public Adresse update(@PathVariable int id, @RequestBody Adresse adresse){
        Adresse existingAdresse = adresseRepository.getOne(id);
        BeanUtils.copyProperties(adresse, existingAdresse, "id_adresse");
        return adresseRepository.saveAndFlush(existingAdresse);
    }
}
