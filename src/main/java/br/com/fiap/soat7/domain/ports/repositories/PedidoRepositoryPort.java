package br.com.fiap.soat7.domain.ports.repositories;

import br.com.fiap.soat7.domain.model.Pedido;

public interface PedidoRepositoryPort {

    Pedido save(Pedido pedido);

    Pedido findById(Long id);
}
