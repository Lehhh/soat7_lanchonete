package br.com.fiap.soat7.domain.ports.interfaces;

import br.com.fiap.soat7.domain.dto.PedidoDTO;
import br.com.fiap.soat7.domain.model.Pedido;

public interface PedidoServicePort {

    Pedido adicionarPedido(PedidoDTO dto);

    Pedido receberPedido(Long id);

    Pedido prepararPedido(Long id);

    Pedido finalizarPedido(Long id);
}
