package br.com.fiap.soat7.domain.ports.interfaces;

import java.util.List;

import br.com.fiap.soat7.domain.dto.PedidoDTO;
import br.com.fiap.soat7.domain.model.Pedido;

public interface PedidoServicePort {

    Pedido adicionarPedido(PedidoDTO dto);

    Pedido marcarComoPronto(Long id) ;

    Pedido prepararPedido(Long id);

    Pedido finalizarPedido(Long id);

    List<Pedido> buscarPedidos();

}
