package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPedido;

public class MarcarPedidoProntoInterector {

    private PedidoGateway pedidoGateway;


    public MarcarPedidoProntoInterector(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido marcarComoPronto(Long id) {
        Pedido pedido = this.pedidoGateway.buscarPorId(id);
        pedido.setStatus(StatusPedido.PRONTO);
        return pedidoGateway.marcarComoPronto(pedido);
    }
}
