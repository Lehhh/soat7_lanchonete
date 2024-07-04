package br.com.fiap.soat7.config;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.application.usecases.pedido.*;
import br.com.fiap.soat7.infrastructure.gateways.PedidoRepositoryGateway;
import br.com.fiap.soat7.infrastructure.persistence.PedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoConfig {

    @Bean
    AdicionarPedidoInterector criarPedidoUseCase(PedidoGateway pedidoGateway) {
        return new AdicionarPedidoInterector(pedidoGateway);
    }

    @Bean
    BuscarTodosPedidosInterector buscarTodosPedidosUseCase(PedidoGateway pedidoGateway) {
        return new BuscarTodosPedidosInterector(pedidoGateway);
    }

    @Bean
    FinalizarPedidoInterector finalizarPedidoUseCase(PedidoGateway pedidoGateway) {
        return new FinalizarPedidoInterector(pedidoGateway);
    }

    @Bean
    MarcarPedidoProntoInterector marcarPedidoProntoUseCase(PedidoGateway pedidoGateway) {
        return new MarcarPedidoProntoInterector(pedidoGateway);
    }

    @Bean
    PrepararPedidoInterector prepararPedidoUseCase(PedidoGateway pedidoGateway) {
        return new PrepararPedidoInterector(pedidoGateway);
    }

    @Bean
    PedidoGateway pedidoGateway(PedidoRepository pedidoRepository) {
        return new PedidoRepositoryGateway(pedidoRepository);
    }
}
