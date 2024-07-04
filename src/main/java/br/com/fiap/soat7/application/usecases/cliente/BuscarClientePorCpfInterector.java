package br.com.fiap.soat7.application.usecases.cliente;

import br.com.fiap.soat7.application.gateways.ClienteGateway;
import br.com.fiap.soat7.domain.entity.Cliente;

public class BuscarClientePorCpfInterector {

    private ClienteGateway clienteGateway;

    public BuscarClientePorCpfInterector(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente buscarClientePorCpf(String cpf ) {
        return clienteGateway.findByCpf(cpf);
    }
}
