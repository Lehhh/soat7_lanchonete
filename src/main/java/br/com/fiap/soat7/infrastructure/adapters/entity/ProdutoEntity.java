package br.com.fiap.soat7.infrastructure.adapters.entity;

import br.com.fiap.soat7.domain.types.Categoria;
import br.com.fiap.soat7.domain.model.Produto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto")
@Getter
@Setter
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String descricao;
    private String imagem;

    @ManyToMany(mappedBy = "produtoList")
    private List<PedidoEntity> pedidos;

    public ProdutoEntity() {}

    public ProdutoEntity(Long id) {
        this.id = id;
    }

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
