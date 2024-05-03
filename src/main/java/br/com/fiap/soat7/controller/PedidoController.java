package br.com.fiap.soat7.controller;

import br.com.fiap.soat7.model.Cliente;
import br.com.fiap.soat7.model.dto.PedidoDTO;
import br.com.fiap.soat7.model.pedidos.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/pedido")
public class PedidoController {

    @GetMapping
    public ResponseEntity<PedidoDTO> findPedido(@RequestParam Integer id, Long cpf){
        return null;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO){
        return null;
    }
    @DeleteMapping
    public ResponseEntity<PedidoDTO> deletePedido(@RequestParam Integer id){
        return null;
    }
    @PutMapping
    public ResponseEntity<PedidoDTO> updatePedido(@RequestBody Pedido pedido){
        return null;
    }
    @PutMapping(value = "/status")
    public ResponseEntity<PedidoDTO> updateStatusPedido(@RequestBody  String status){

        return null;
    }


    @GetMapping(value = "/list")
    public ResponseEntity<List<PedidoDTO>> fetchPedidosByCpf(@RequestParam Long cpf){
        return null;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<PedidoDTO>> fetchPedidosByStatus(@RequestParam String status){
        return null;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<PedidoDTO>> fetchPedidos(){
        return null;
    }
}
