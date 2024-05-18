package br.com.fiap.soat7.infrastructure.adapters.entity;

import br.com.fiap.soat7.domain.model.Categoria;
import br.com.fiap.soat7.domain.model.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String descricao;
    private String imagem;

    public ProdutoEntity() {}

    public void atualizar(Produto produto) {
        this.nome = produto.getNome();
        this.categoria = produto.getCategoria();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.imagem = produto.getImagem();
    }

    public ProdutoEntity(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
        this.descricao = produto.getDescricao();
        this.imagem = produto.getImagem();
    }

    public Produto toProduto () {
        return new Produto(this.id, this.nome, this.categoria, this.preco, this.descricao, this.imagem);
    }
}
