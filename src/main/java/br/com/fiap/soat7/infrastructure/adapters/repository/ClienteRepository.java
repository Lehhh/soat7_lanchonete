package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.domain.model.Cliente;
import br.com.fiap.soat7.domain.ports.repositories.ClienteRepositoryPort;
import br.com.fiap.soat7.infrastructure.adapters.entity.ClienteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ClienteRepository implements ClienteRepositoryPort {
    private final IClienteRepository clienteRepository;

    public ClienteRepository(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity clienteEntity;

        if(Objects.isNull(cliente.getId())) {
            clienteEntity = new ClienteEntity(cliente);
        } else {
            clienteEntity = this.clienteRepository.findByCpf(cliente.getCpf()).get();
            clienteEntity.atualizar(cliente);
        }

        ClienteEntity clienteSalvo = this.clienteRepository.save(clienteEntity);
        if(Objects.nonNull(clienteSalvo)) {
            cliente.setId(clienteSalvo.getId());
        }
        return cliente;
    }

    @Override
    public Cliente findByCpf(String cpf) {
        Optional<ClienteEntity> clienteEntity = this.clienteRepository.findByCpf(cpf);

        if (clienteEntity.isPresent())
            return clienteEntity.get().toCliente();

        throw new RuntimeException("Cliente não existe");
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll().stream().map(Cliente::new).toList();
    }
}

