package br.com.fiap.soat7.domain.dto;

import br.com.fiap.soat7.domain.types.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
}
