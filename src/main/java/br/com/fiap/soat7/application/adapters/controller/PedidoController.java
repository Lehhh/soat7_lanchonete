package br.com.fiap.soat7.application.adapters.controller;

import br.com.fiap.soat7.domain.dto.PedidoDTO;
import br.com.fiap.soat7.domain.model.Pedido;
import br.com.fiap.soat7.domain.ports.interfaces.PedidoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v1/pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = pedidoServicePort.adicionarPedido(dto);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping("/{id}/receber")
    public ResponseEntity<Pedido> receberPedido(@PathVariable Long id) {
        Pedido pedido = pedidoServicePort.receberPedido(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping("/{id}/preparar")
    public ResponseEntity<Pedido> prepararPedido(@PathVariable Long id) {
        Pedido pedido = pedidoServicePort.prepararPedido(id);
        return ResponseEntity.ok().body(pedido);
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Pedido> finalizarPedido(@PathVariable Long id) {
        Pedido pedido = pedidoServicePort.finalizarPedido(id);
        return ResponseEntity.ok().body(pedido);
    }

}
