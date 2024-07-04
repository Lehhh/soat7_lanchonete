package br.com.fiap.soat7.infrastructure.gateways;

import br.com.fiap.soat7.application.gateways.ClienteGateway;
import br.com.fiap.soat7.domain.entity.Cliente;
import br.com.fiap.soat7.infrastructure.persistence.IClienteRepository;
import br.com.fiap.soat7.infrastructure.persistence.entity.ClienteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteRepositoryGateway implements ClienteGateway {

    private final IClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteRepositoryGateway(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
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

