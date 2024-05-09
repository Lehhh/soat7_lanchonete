package br.com.fiap.soat7.domain.adapters.services;

import br.com.fiap.soat7.domain.dto.ClienteDTO;
import br.com.fiap.soat7.domain.model.Cliente;
import br.com.fiap.soat7.domain.ports.interfaces.ClienteServicePort;
import br.com.fiap.soat7.domain.ports.repositories.ClienteRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ClienteServiceImpl implements ClienteServicePort {


    private final ClienteRepositoryPort clienteRepository;

    public ClienteServiceImpl(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public Cliente adicionarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());

        Cliente clienteSalvo = this.clienteRepository.save(cliente);
        return clienteSalvo;
    }

    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        Cliente cliente = this.clienteRepository.findByCpf(cpf);

        if(Objects.isNull(cliente)) {
            throw new RuntimeException("Nenhum cliente foi encontrado");
        }
        return cliente;
    }
}
