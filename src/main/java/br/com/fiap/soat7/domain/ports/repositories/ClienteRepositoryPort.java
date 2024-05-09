package br.com.fiap.soat7.domain.ports.repositories;

import br.com.fiap.soat7.domain.model.Cliente;

public interface ClienteRepositoryPort {

    Cliente save (Cliente cliente);

    Cliente findByCpf (String cpf);
}
