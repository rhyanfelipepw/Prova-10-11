package com.provaRhyan.demo.repositories;

import com.provaRhyan.demo.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RepositoryContato extends JpaRepository<Contato, Long> {


    Optional<Contato> findByEmail(String email);
    Optional<Contato> findByTelefone(String Telefone);


}

