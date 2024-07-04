package br.com.fiap.soat7.domain.entity;

import br.com.fiap.soat7.infrastructure.persistence.entity.ClienteEntity;
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

    public Cliente(ClienteEntity clienteEntity) {
        this.nome = clienteEntity.getNome();
        this.cpf = clienteEntity.getCpf();
        this.email = clienteEntity.getEmail();
    }
}
