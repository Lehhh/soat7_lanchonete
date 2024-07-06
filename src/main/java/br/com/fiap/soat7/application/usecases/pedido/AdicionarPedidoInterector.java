package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPedido;

import java.util.Date;

public class AdicionarPedidoInterector {

    private PedidoGateway pedidoGateway;


    public AdicionarPedidoInterector(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido criarPedido(Pedido pedido) {
        pedido.setDataCadastro(new Date());
        this.checkoutMercadoPago(pedido);
        pedido.setStatus(StatusPedido.RECEBIDO);
        return pedidoGateway.adicionarPedido(pedido);
    }

    private boolean checkoutMercadoPago(Pedido pedido){
        return true;
    }
}
