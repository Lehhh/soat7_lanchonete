package br.com.fiap.soat7.domain.model;

import br.com.fiap.soat7.domain.types.Categoria;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Produto {

    private Long id;
    private String nome;
    private Categoria categoria;
    private BigDecimal preco;
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

    public Produto(ProdutoEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.categoria = entity.getCategoria();
        this.preco = entity.getPreco();
        this.descricao = entity.getDescricao();
        this.imagem = entity.getImagem();
    }
}
