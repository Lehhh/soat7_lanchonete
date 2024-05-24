package br.com.fiap.soat7.domain.ports.interfaces;

import br.com.fiap.soat7.domain.dto.ClienteDTO;
import br.com.fiap.soat7.domain.model.Cliente;

public interface ClienteServicePort {

    Cliente adicionarCliente (ClienteDTO cliente);

    Cliente buscarClientePorCpf (String cpf);
}
