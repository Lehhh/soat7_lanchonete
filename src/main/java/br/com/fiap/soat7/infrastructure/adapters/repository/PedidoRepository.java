package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.domain.model.Pedido;
import br.com.fiap.soat7.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.soat7.infrastructure.adapters.entity.PedidoEntity;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;


@Component
public class PedidoRepository implements PedidoRepositoryPort {

    private final IPedidoRepository pedidoRepository;

    public PedidoRepository(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido save(Pedido pedido) {
        PedidoEntity savedPedidoEntity = this.pedidoRepository.save(new PedidoEntity(pedido));
        return savedPedidoEntity.toPedido();
    }

    @Override
    public Pedido findById(Long id) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElseThrow(() -> {
            String errorMessage = "Pedido de id " + id + " nao encontrado!";
            return new NoSuchElementException(errorMessage);
        });
        return pedidoEntity.toPedido();
    }
}
