package com.provaRhyan.demo.service;

import com.provaRhyan.demo.models.Contato;
import com.provaRhyan.demo.repositories.RepositoryContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class contatoService {
    @Autowired
    private RepositoryContato repository;


    public String criaContato(Contato contato){
        if (repository.findByEmail(contato.getEmail()).isPresent())
            return "O numero informado já está em uso";
        if (repository.findByTelefone(contato.getTelefone()).isPresent())
            return "O email informado já está em uso";

        repository.save(contato);
       return "OK";
    }

    public String editarContato(Contato contato){
       Optional<Contato> contatoEditado =  repository.findById(contato.getId());
       if(contatoEditado.isEmpty())
           return "O contato não existe no banco de dados";
       repository.save(contato);
       return "Contato editado com sucesso!";
    }

    public String deletaContato(Contato contato){
        repository.delete(contato);
        return "sucess";
    }

    public List<Contato> buscarContatos(){
        return repository.findAll();
    }

    public Optional<Contato> buscaContatoPorId(Long id){
        return repository.findById(id);
    }

}
