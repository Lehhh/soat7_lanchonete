package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPagamento;
import br.com.fiap.soat7.domain.types.StatusPedido;

import java.util.Date;

public class AdicionarPedidoUsecase {

    private PedidoGateway pedidoGateway;


    public AdicionarPedidoUsecase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido criarPedido(Pedido pedido) {
        pedido.setDataCadastro(new Date());
        boolean isPago = this.checkoutMercadoPago(pedido);
        if(isPago) {
            pedido.setStatusPagamento(StatusPagamento.APROVADO);
        }
        pedido.setStatus(StatusPedido.RECEBIDO);
        return pedidoGateway.adicionarPedido(pedido);
    }

    private boolean checkoutMercadoPago(Pedido pedido){
        return true;
    }
}
