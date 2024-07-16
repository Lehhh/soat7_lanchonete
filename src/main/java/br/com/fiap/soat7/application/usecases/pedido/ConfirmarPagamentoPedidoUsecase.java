package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPagamento;

public class ConfirmarPagamentoPedidoUsecase {

    private final PedidoGateway pedidoGateway;

    public ConfirmarPagamentoPedidoUsecase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public void confirmarPagamento(Long id) {
        Pedido pedido = this.pedidoGateway.buscarPorId(id);
        pedido.setStatusPagamento(StatusPagamento.APROVADO);
        pedidoGateway.adicionarPedido(pedido);
    }
}
