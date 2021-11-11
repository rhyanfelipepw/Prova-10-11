package com.provaRhyan.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nmContato;
    String email;
    String telefone;

    public Contato(Long id, String nmContato, String email, String telefone) {
        this.id = id;
        this.nmContato = nmContato;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefone() {
        return telefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.telefone = nrTelefone;
    }
}
