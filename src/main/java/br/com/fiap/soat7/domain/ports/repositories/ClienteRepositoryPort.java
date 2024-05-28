package br.com.fiap.soat7.domain.ports.repositories;

import br.com.fiap.soat7.domain.model.Cliente;

import java.util.List;

public interface ClienteRepositoryPort {

    Cliente save (Cliente cliente);

    Cliente findByCpf (String cpf);
    List<Cliente> findAll();
}
