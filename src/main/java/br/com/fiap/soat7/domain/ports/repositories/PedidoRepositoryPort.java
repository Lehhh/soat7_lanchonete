package br.com.fiap.soat7.domain.ports.repositories;

import java.util.List;

import br.com.fiap.soat7.domain.model.Pedido;

public interface PedidoRepositoryPort {

    Pedido save(Pedido pedido);

    Pedido findById(Long id);

    List<Pedido> findAll();

}
