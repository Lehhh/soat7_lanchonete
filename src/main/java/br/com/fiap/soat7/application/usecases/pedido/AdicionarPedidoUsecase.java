package br.com.fiap.soat7.application.usecases.pedido;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPagamento;
import br.com.fiap.soat7.domain.types.StatusPedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class AdicionarPedidoUsecase {

    private static final Logger log = LoggerFactory.getLogger(AdicionarPedidoUsecase.class);
    private final PedidoGateway pedidoGateway;


    public AdicionarPedidoUsecase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }


    public Pedido criarPedido(Pedido pedido) {
        pedido.setDataCadastro(new Date());
        if(this.checkoutMercadoPago()) {
            pedido.setStatusPagamento(StatusPagamento.APROVADO);
        }
        pedido.setStatus(StatusPedido.RECEBIDO);
        return pedidoGateway.adicionarPedido(pedido);
    }

    private boolean checkoutMercadoPago(){
        try {
            log.info("Simulando checkout em plataforma externa...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("Erro ao simular checkout: ", e);
            Thread.currentThread().interrupt();
            return false;
        }
        return Math.random() == 0.1;
    }
}
