package br.com.fiap.soat7.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO {

    private String nome;

    private BigDecimal preco;
}
