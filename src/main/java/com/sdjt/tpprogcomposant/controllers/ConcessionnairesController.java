package com.sdjt.tpprogcomposant.controllers;

import com.sdjt.tpprogcomposant.models.Concessionnaire;
import com.sdjt.tpprogcomposant.models.Marque;
import com.sdjt.tpprogcomposant.repositories.ConcessionnaireRepository;
import org.springframework.beans.BeanUtils;
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

    @PostMapping
    public Concessionnaire create(@RequestBody Concessionnaire concessionnaire) {
        return concessionnaireRepository.saveAndFlush(concessionnaire);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id) {
        concessionnaireRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public Concessionnaire update(@PathVariable int id, @RequestBody Concessionnaire concessionnaire){
        Concessionnaire existingConcessionnaire = concessionnaireRepository.getOne(id);
        BeanUtils.copyProperties(concessionnaire, existingConcessionnaire, "id_concessionnaire");
        return concessionnaireRepository.saveAndFlush(existingConcessionnaire);
    }
}
