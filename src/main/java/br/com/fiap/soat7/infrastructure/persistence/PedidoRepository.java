package br.com.fiap.soat7.infrastructure.persistence;

import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.infrastructure.persistence.entity.PedidoEntity;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;


@Component
public class PedidoRepository {

    private final IPedidoRepository repository;

    public PedidoRepository(IPedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido save(Pedido pedido) {
        try {
            PedidoEntity savedPedidoEntity = this.repository.save(new PedidoEntity(pedido));
            return repository.findByIdWithProduto(savedPedidoEntity.getId()).get().toPedido();
        } catch (Exception e) {
            String message = "Erro ao salvar os valores informados. Verifique as valores informados.";
            if (e.getMessage().contains("Referential integrity constraint violation")){
                message = "Um ou mais produtos da lista não foi encontrado. Verifique os valores informados.";
            }
            throw new DataIntegrityViolationException(message);
        }
    }

    public Pedido findById(Long id) {
        PedidoEntity pedidoEntity = repository.findById(id).orElseThrow(() -> {
            String errorMessage = String.format("O Pedido [%s] não foi encontrado.", id);
            return new NoSuchElementException(errorMessage);
        });
        return pedidoEntity.toPedido();
    }

    public List<Pedido> findAll(){
        return this.repository.findAll().stream().map(PedidoEntity::toPedido).toList();
    }
}
