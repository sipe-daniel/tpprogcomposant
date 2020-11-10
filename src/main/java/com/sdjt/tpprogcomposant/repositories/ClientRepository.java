package com.sdjt.tpprogcomposant.repositories;


import com.sdjt.tpprogcomposant.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> { }
