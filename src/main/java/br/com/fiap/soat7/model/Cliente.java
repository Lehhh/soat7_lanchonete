package br.com.fiap.soat7.model;

import br.com.fiap.soat7.model.pedidos.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    private Long clienteId;
    private String name;
    private Long cpf;
    private String email;

    @OneToMany(mappedBy = "clientePedido")
    private List<Pedido> pedidos;

}
