package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;

public class MarcarPedidoProntoInterector {

    private PedidoGateway pedidoGateway;


    public MarcarPedidoProntoInterector(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido marcarComoPronto(Long id) {

        return pedidoGateway.marcarComoPronto(id);
    }
}
