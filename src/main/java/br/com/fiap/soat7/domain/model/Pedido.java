package br.com.fiap.soat7.domain.model;

import br.com.fiap.soat7.domain.types.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class Pedido {

    private Long id;
    private String cpf;
    private LocalDate data;
    private LocalTime hora;
    private StatusPedido status;
    private List<Produto> produtoList;

    public Pedido(Long id, String cpf, LocalDate data, LocalTime hora, StatusPedido status, List<Produto> produtoList) {
        this.id = id;
        this.cpf = cpf;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.produtoList = produtoList;
    }

}
