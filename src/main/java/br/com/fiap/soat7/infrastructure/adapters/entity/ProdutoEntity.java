package br.com.fiap.soat7.infrastructure.adapters.entity;

import br.com.fiap.soat7.domain.model.Cliente;
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

    public ProdutoEntity() {

    }

    public void atualizar(Produto cliente) {
        this.nome = cliente.getNome();
    }

    public ProdutoEntity(Produto produto) {
        this.nome = produto.getNome();
    }

    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.preco);
    }
}
