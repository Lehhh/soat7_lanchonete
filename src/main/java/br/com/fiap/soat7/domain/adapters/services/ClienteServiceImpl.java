package br.com.fiap.soat7.domain.adapters.services;

import br.com.fiap.soat7.domain.dto.ClienteDTO;
import br.com.fiap.soat7.domain.model.Cliente;
import br.com.fiap.soat7.domain.ports.interfaces.ClienteServicePort;
import br.com.fiap.soat7.domain.ports.repositories.ClienteRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteServiceImpl implements ClienteServicePort {


    private final ClienteRepositoryPort clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ClienteServiceImpl(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public Cliente adicionarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        Cliente cliente = this.clienteRepository.findByCpf(cpf);

        if(Objects.isNull(cliente)) {
            throw new RuntimeException("Nenhum cliente foi encontrado");
        }
        return cliente;
    }

    @Override
    public List<Cliente> buscarTodosOsCliente() {
        return this.clienteRepository.findAll();
    }
}
