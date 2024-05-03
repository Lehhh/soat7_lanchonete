package br.com.fiap.soat7.controller;

import br.com.fiap.soat7.model.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/v1/lanchonete")
public class LanchoneteController {

    public ResponseEntity<ClienteDTO> access(@RequestParam String cpf){

        return null;
    }
}
