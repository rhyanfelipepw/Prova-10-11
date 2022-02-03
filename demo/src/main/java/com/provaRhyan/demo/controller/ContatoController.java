package com.provaRhyan.demo.controller;


import com.provaRhyan.demo.models.Contato;
import com.provaRhyan.demo.repositories.RepositoryContato;
import com.provaRhyan.demo.service.contatoService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(
        origins = {"*"},
        maxAge = 3600,
        allowCredentials = "false")
@RestController
@RequestMapping({"/contato"})
public class ContatoController {
    @Autowired
    private contatoService service;

    @PostMapping(path = "/criarContato")
    public String criaUsuario(@RequestBody Contato contato) {
        try {
            String response = service.criaContato(contato);
            return response;
        } catch (Exception e) {
            return e.toString();
        }
    }

    @GetMapping(path = "/getContatos")
    public List<Contato> getAllContatos() {
        return service.buscarContatos();
    }

    @GetMapping(path = "/getContato")
    public Optional<Contato> getContadoById(@RequestParam long idUsuario) {
        return service.buscaContatoPorId(idUsuario);
    }

    @PutMapping(path = "/editContato")
    public ResponseEntity<String> editContato(@RequestBody Contato contato) {
        try{
            service.editarContato(contato);
              return  new ResponseEntity("",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/deleteContato")
    public String deleteContato(@RequestBody Contato contato) {
        try {
            service.deletaContato(contato);
            return "Ok";
        } catch (Exception e) {
            return e.toString();
        }
    }


}
