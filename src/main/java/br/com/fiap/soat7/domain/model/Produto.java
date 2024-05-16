package br.com.fiap.soat7.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {

    Long id;
    String nome;

    public Produto() {

    }

    public Produto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
