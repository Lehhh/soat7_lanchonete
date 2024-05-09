package br.com.fiap.soat7.infrastructure.adapters.entity;

import br.com.fiap.soat7.domain.model.Cliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    public ClienteEntity() {

    }

    public ClienteEntity(Cliente cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
    }

    public void atualizar(Cliente cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
    }

    public Cliente toCliente() {
        return new Cliente(this.id, this.nome, this.cpf, this.email);
    }
}
