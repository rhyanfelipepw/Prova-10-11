package com.provaRhyan.demo.controller;


import com.provaRhyan.demo.models.Contato;
import com.provaRhyan.demo.repositories.RepositoryContato;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/contato"})
public class ContatoController {

    @Autowired
    private RepositoryContato repository;

    @PostMapping(path = "/criarContato")
    public String criaUsuario(@RequestBody Contato contato) {
        if (repository.findByEmail(contato.getEmail()).isPresent())
            return "O numero informado já está em uso";
        if (repository.findByTelefone(contato.getNrTelefone()).isPresent())
            return "O email informado já está em uso";

        try {
            repository.save(contato);
            return "Sucess";
        } catch (Exception e) {
            return e.toString();

        }


    }

    @GetMapping(path = "/getContatos")
    public List<Contato> getAllContatos() {
        return repository.findAll();
    }

    @GetMapping(path = "/getContato")
    public Contato getContadoById(@RequestParam long idUsuario) {
        return repository.getById(idUsuario);
    }

    @PutMapping(path = "/editContato")
    public Contato editContato(@RequestBody Contato contato) {
        return repository.save(contato);
    }

    @DeleteMapping(path = "/deleteContato")
    public String deleteContato(@RequestBody Contato contato) {
        try {
            repository.delete(contato);
            return "Ok";
        } catch (Exception e) {
            return e.toString();
        }
    }


}
