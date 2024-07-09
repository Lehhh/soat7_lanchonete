package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPedido;

public class ConsultarStatusPagamentoPedidoUsecase {
    private PedidoGateway pedidoGateway;


    public ConsultarStatusPagamentoPedidoUsecase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido consultarStatusPagamentoPedido(Long id) {
        return pedidoGateway.buscarPorId(id);
    }
}
