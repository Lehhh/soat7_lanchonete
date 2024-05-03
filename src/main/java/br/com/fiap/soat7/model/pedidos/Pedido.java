package br.com.fiap.soat7.model.pedidos;

import br.com.fiap.soat7.model.Cliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    private Long idPedido;
    @OneToMany(mappedBy = "pedidoLanche")
    private List<Lanche> lanches;
    @OneToMany(mappedBy = "pedidoAcompanhamento")
    private List<Acompanhamento> acompanhamentos;
    @OneToMany(mappedBy = "pedidoBebida")
    private List<Bebida> bebidas;
    @OneToMany(mappedBy = "pedidoSobremesa")
    private List<Sobremesa> sobremesas;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente clientePedido;
}
