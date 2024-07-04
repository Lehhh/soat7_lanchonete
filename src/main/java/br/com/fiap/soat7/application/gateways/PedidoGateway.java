package br.com.fiap.soat7.application.gateways;


import br.com.fiap.soat7.domain.entity.Pedido;

import java.util.List;

public interface PedidoGateway {

    Pedido adicionarPedido(Pedido pedido);

    Pedido marcarComoPronto(Long id) ;

    Pedido prepararPedido(Long id);

    Pedido finalizarPedido(Long id);

    List<Pedido> buscarPedidos();
}
