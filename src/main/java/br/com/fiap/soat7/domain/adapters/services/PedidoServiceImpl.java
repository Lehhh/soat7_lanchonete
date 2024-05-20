package br.com.fiap.soat7.domain.adapters.services;

import br.com.fiap.soat7.domain.dto.PedidoDTO;
import br.com.fiap.soat7.domain.model.Pedido;
import br.com.fiap.soat7.domain.ports.interfaces.PedidoServicePort;
import org.springframework.stereotype.Component;

@Component
public class PedidoServiceImpl implements PedidoServicePort {

    @Override
    public Pedido adicionarPedido(PedidoDTO dto) {
        return null;
    }

    @Override
    public Pedido receberPedido(Long id) {
        return null;
    }

    @Override
    public Pedido prepararPedido(Long id) {
        return null;
    }

    @Override
    public Pedido finalizarPedido(Long id) {
        return null;
    }
}
