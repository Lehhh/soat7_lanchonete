package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;

public class FinalizarPedidoInterector {

    private PedidoGateway pedidoGateway;


    public FinalizarPedidoInterector(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido finalizarPedido(Long id) {

        return pedidoGateway.finalizarPedido(id);
    }
}
