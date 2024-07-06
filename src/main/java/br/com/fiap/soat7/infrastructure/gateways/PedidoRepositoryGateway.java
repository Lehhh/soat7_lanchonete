package br.com.fiap.soat7.infrastructure.gateways;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Cliente;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPedido;
import br.com.fiap.soat7.infrastructure.persistence.PedidoRepository;
import br.com.fiap.soat7.infrastructure.persistence.entity.ClienteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PedidoRepositoryGateway implements PedidoGateway {

    private final PedidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public PedidoRepositoryGateway(PedidoRepository repository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Pedido adicionarPedido(Pedido pedido) {
        return this.repository.save(pedido);
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return this.repository.findAll();
    }

    @Override
    public Pedido buscarPorId(Long id) {
     return this.repository.findById(id);
    }



}
