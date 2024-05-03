package br.com.fiap.soat7.model.dto;

import br.com.fiap.soat7.model.Cliente;
import br.com.fiap.soat7.model.pedidos.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

public class PedidoDTO {

    private Long idPedido;
    private List<Lanche> lanches;
    private List<Acompanhamento> acompanhamentos;
    private List<Bebida> bebidas;
    private List<Sobremesa> sobremesas;
    private ClienteDTO clientePedido;
    private Status status;
}
