package br.com.fiap.soat7.application.adapters.controller;

import br.com.fiap.soat7.domain.dto.ClienteDTO;
import br.com.fiap.soat7.domain.model.Cliente;
import br.com.fiap.soat7.domain.ports.interfaces.ClienteServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/clientes")
public class ClienteController {


    private final ClienteServicePort clienteServicePort;

    public ClienteController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }

    @PostMapping
    public ResponseEntity<Cliente> adicionarCliente(@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteServicePort.adicionarCliente(clienteDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf){
        Cliente cliente = clienteServicePort.buscarClientePorCpf(cpf);
        return ResponseEntity.ok().body(cliente);
    }
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> buscarTodos(){
        List<Cliente> clientes = clienteServicePort.buscarTodosOsCliente();
        return ResponseEntity.ok().body(clientes);
    }


}
