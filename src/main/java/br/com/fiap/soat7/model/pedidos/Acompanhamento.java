package br.com.fiap.soat7.model.pedidos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Acompanhamento {
    @Id
    private Long idAcompanhamento;
    private String name;
    private String quantidade;
    @ManyToOne
    @JoinColumn(name = "id")
    private Pedido pedidoAcompanhamento;
}
