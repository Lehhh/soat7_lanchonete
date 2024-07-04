package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;

import java.util.List;

public class BuscarTodosPedidosInterector {

    private PedidoGateway pedidoGateway;


    public BuscarTodosPedidosInterector(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public List<Pedido> buscarPedidos() {

        return pedidoGateway.buscarPedidos();
    }


}
