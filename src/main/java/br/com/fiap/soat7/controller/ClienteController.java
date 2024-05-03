package br.com.fiap.soat7.controller;

import br.com.fiap.soat7.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/client")
public class ClienteController {

    @GetMapping
    public ResponseEntity<Cliente> findCliente(@RequestParam String cpf){

        return null;
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        return null;
    }
    @DeleteMapping
    public ResponseEntity<Cliente> deleteCliente(@RequestParam Integer id){
        return null;
    }
    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> fetchClientes(@RequestParam String cpf){
        return null;
    }


}
