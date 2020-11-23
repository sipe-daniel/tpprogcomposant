package com.sdjt.tpprogcomposant.controllers;

import com.sdjt.tpprogcomposant.models.Client;
import com.sdjt.tpprogcomposant.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id) {
        clientRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public Client update(@PathVariable int id, @RequestBody Client client){
        Client existingClient = clientRepository.getOne(id);
        BeanUtils.copyProperties(client, existingClient, "id_client");
        return clientRepository.saveAndFlush(existingClient);
    }

}
