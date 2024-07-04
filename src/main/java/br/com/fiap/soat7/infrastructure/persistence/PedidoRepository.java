package br.com.fiap.soat7.infrastructure.persistence;

import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.infrastructure.persistence.entity.PedidoEntity;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;


@Component
public class PedidoRepository {

    private final IPedidoRepository pedidoRepository;

    public PedidoRepository(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

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

    public Pedido findById(Long id) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElseThrow(() -> {
            String errorMessage = "Pedido de id " + id + " nao encontrado!";
            return new NoSuchElementException(errorMessage);
        });
        return pedidoEntity.toPedido();
    }

    public List<Pedido> findAll(){
        return this.pedidoRepository.findAll().stream().map(PedidoEntity::toPedido).toList();
    }
}
