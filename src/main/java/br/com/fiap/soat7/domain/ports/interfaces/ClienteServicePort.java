package br.com.fiap.soat7.domain.ports.interfaces;

import br.com.fiap.soat7.domain.dto.ClienteDTO;
import br.com.fiap.soat7.domain.model.Cliente;

import java.util.List;

public interface ClienteServicePort {

    Cliente adicionarCliente (ClienteDTO cliente);

    Cliente buscarClientePorCpf (String cpf);

    List<Cliente> buscarTodosOsCliente();
}
