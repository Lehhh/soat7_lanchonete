package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;

public class PrepararPedidoInterector {

    private PedidoGateway pedidoGateway;


    public PrepararPedidoInterector(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido prepararPedido(Long id) {
        return pedidoGateway.prepararPedido(id);
    }
}
