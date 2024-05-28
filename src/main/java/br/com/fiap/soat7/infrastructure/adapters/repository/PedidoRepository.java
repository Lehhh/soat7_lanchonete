package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.domain.model.Pedido;
import br.com.fiap.soat7.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.soat7.infrastructure.adapters.entity.PedidoEntity;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;


@Component
public class PedidoRepository implements PedidoRepositoryPort {

    private final IPedidoRepository pedidoRepository;

    public PedidoRepository(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido save(Pedido pedido) {
        try {
            PedidoEntity savedPedidoEntity = this.pedidoRepository.save(new PedidoEntity(pedido));
            return savedPedidoEntity.toPedido();
        } catch (Exception e) {
            String message = "Erro ao salvar os valores informados. Verifique as valores informados.";
            if (e.getMessage().contains("Referential integrity constraint violation")){
                message = "Um ou mais produtos da lista não foi encontrado. Verifique os valores informados.";
            }
            throw new DataIntegrityViolationException(message);
        }
    }

    @Override
    public Pedido findById(Long id) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElseThrow(() -> {
            String errorMessage = "Pedido de id " + id + " nao encontrado!";
            return new NoSuchElementException(errorMessage);
        });
        return pedidoEntity.toPedido();
    }

    @Override
    public List<Pedido> findAll(){
        return this.pedidoRepository.findAll().stream().map(PedidoEntity::toPedido).toList();
    }
}
