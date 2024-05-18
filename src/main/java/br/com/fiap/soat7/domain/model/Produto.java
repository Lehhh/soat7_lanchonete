package br.com.fiap.soat7.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Produto {

    private Long id;
    private String nome;
    private Categoria categoria;
    BigDecimal preco;
    private String descricao;
    private String imagem;


    public Produto() {

    }

    public Produto(Long id, String nome, Categoria categoria, BigDecimal preco, String descricao, String imagem) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }
}
