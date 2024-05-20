package br.com.fiap.soat7.domain.dto;

import br.com.fiap.soat7.domain.model.Produto;
import br.com.fiap.soat7.domain.types.StatusPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PedidoDTO {

    private String cpf;
    private LocalDate data;
    private LocalTime hora;
    private StatusPedido status;
    private List<Produto> produtoList;
}
