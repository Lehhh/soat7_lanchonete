package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;

public class AdicionarPedidoInterector {

    private PedidoGateway pedidoGateway;


    public AdicionarPedidoInterector(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido criarPedido(Pedido pedido) {
        return pedidoGateway.adicionarPedido(pedido);
    }
}
