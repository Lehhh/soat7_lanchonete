package br.com.fiap.soat7.infrastructure.controllers.pedido;

import br.com.fiap.soat7.application.usecases.pedido.*;
import br.com.fiap.soat7.domain.entity.Pedido;

import java.util.List;

import br.com.fiap.soat7.infrastructure.controllers.pedido.request.PedidoRequest;
import br.com.fiap.soat7.infrastructure.controllers.pedido.response.PedidoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/v1/pedidos")
public class PedidoController {

    private final AdicionarPedidoInterector adicionarPedidoInterector;
    private final MarcarPedidoProntoInterector marcarPedidoProntoInterector;

    private final PrepararPedidoInterector prepararPedidoInterector;

    private final FinalizarPedidoInterector finalizarPedidoInterector;

    private final BuscarTodosPedidosInterector buscarTodosPedidosInterector;
    @Autowired
    private ModelMapper modelMapper;


    public PedidoController(AdicionarPedidoInterector adicionarPedidoInterector,
                            MarcarPedidoProntoInterector marcarPedidoProntoInterector,
                            PrepararPedidoInterector prepararPedidoInterector,
                            FinalizarPedidoInterector finalizarPedidoInterector,
                            BuscarTodosPedidosInterector buscarTodosPedidosInterector) {
        this.adicionarPedidoInterector = adicionarPedidoInterector;
        this.marcarPedidoProntoInterector = marcarPedidoProntoInterector;
        this.prepararPedidoInterector = prepararPedidoInterector;
        this.finalizarPedidoInterector = finalizarPedidoInterector;
        this.buscarTodosPedidosInterector = buscarTodosPedidosInterector;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> adicionarPedido(@RequestBody PedidoRequest request) {
        Pedido pedidoRequest = modelMapper.map(request, Pedido.class);
        PedidoResponse response = modelMapper.map(adicionarPedidoInterector.criarPedido(pedidoRequest), PedidoResponse.class);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{id}/pronto")
    public ResponseEntity<PedidoResponse> marcarComoPronto(@PathVariable Long id) {
        Pedido pedido = marcarPedidoProntoInterector.marcarComoPronto(id);
        PedidoResponse response = modelMapper.map(pedido, PedidoResponse.class);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{id}/preparar")
    public ResponseEntity<PedidoResponse> prepararPedido(@PathVariable Long id) {
        Pedido pedido = prepararPedidoInterector.prepararPedido(id);
        PedidoResponse response = modelMapper.map(pedido, PedidoResponse.class);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<PedidoResponse> finalizarPedido(@PathVariable Long id) {
        Pedido pedido = finalizarPedidoInterector.finalizarPedido(id);
        PedidoResponse response = modelMapper.map(pedido, PedidoResponse.class);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<Pedido>> buscarPedidos(){
        return ResponseEntity.ok().body(buscarTodosPedidosInterector.buscarPedidos());
    }

}
