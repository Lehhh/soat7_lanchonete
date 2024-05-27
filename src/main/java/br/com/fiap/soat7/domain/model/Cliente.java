package br.com.fiap.soat7.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String email;

    public Cliente() {

    }

    public Cliente(Long id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
