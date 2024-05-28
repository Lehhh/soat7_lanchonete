package br.com.fiap.soat7.domain.dto;

import br.com.fiap.soat7.domain.types.Categoria;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO {

    @JsonIgnore
    private Long id;

    private String nome;

    private Categoria categoria;

    BigDecimal preco;

    private String descricao;

    private String imagem;


    public ProdutoDTO (ProdutoEntity entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.categoria = entity.getCategoria();
        this.preco = entity.getPreco();
        this.descricao = entity.getDescricao();
        this.imagem = entity.getImagem();
    }
}
