package br.com.fiap.soat7.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private String nome;
    private String cpf;
    private String email;
}
