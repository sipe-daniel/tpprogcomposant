package com.sdjt.tpprogcomposant.controllers;

import com.sdjt.tpprogcomposant.models.Client;
import com.sdjt.tpprogcomposant.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v0/clients")
public class ClientsController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Client get(@PathVariable int id) {
        return clientRepository.getOne(id);
    }

    /*@PostMapping
    public Client create(@RequestBody final Client Client) {
        return clientRepository.saveAndFlush(client);
    }*/
}
