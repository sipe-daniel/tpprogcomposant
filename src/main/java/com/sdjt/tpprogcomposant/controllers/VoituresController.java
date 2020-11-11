package com.sdjt.tpprogcomposant.controllers;

import com.sdjt.tpprogcomposant.models.Marque;
import com.sdjt.tpprogcomposant.models.Voiture;
import com.sdjt.tpprogcomposant.repositories.VoitureRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/api/v0/voitures")
public class VoituresController {
    @Autowired
    private VoitureRepository voitureRepository;

    @GetMapping
    public List<Voiture> list() {
        return voitureRepository.findAll();
    }

    @GetMapping("{id}")
    public Voiture get(@PathVariable int id) {
        return voitureRepository.getOne(id);
    }

    @PostMapping
    public Voiture create(@RequestBody Voiture voiture) {
        return voitureRepository.saveAndFlush(voiture);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id) {
        voitureRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public Voiture update(@PathVariable int id, @RequestBody Voiture voiture){
        Voiture existingVoiture = voitureRepository.getOne(id);
        BeanUtils.copyProperties(voiture, existingVoiture, "id_voiture");
        return voitureRepository.saveAndFlush(existingVoiture);
    }
}
