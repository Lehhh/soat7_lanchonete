package br.com.fiap.soat7.config;

import br.com.fiap.soat7.application.gateways.ClienteGateway;
import br.com.fiap.soat7.application.usecases.cliente.AdicionarClienteInterector;
import br.com.fiap.soat7.application.usecases.cliente.BuscarClientePorCpfInterector;
import br.com.fiap.soat7.application.usecases.cliente.BuscarTodosClientesInterector;
import br.com.fiap.soat7.infrastructure.gateways.ClienteRepositoryGateway;
import br.com.fiap.soat7.infrastructure.persistence.IClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    AdicionarClienteInterector criarClienteUseCase(ClienteGateway clienteGateway) {
        return new AdicionarClienteInterector(clienteGateway);
    }

    @Bean
    BuscarClientePorCpfInterector buscarClienteUseCase(ClienteGateway clienteGateway) {
        return new BuscarClientePorCpfInterector(clienteGateway);
    }

    @Bean
    BuscarTodosClientesInterector buscarTodosClientesUseCase(ClienteGateway clienteGateway) {
        return new BuscarTodosClientesInterector(clienteGateway);
    }

    @Bean
    ClienteGateway clienteGateway(IClienteRepository clienteRepository) {
        return new ClienteRepositoryGateway(clienteRepository);
    }

}
