package br.com.fiap.soat7.infrastructure.adapters.entity;

import br.com.fiap.soat7.domain.model.Pedido;
import br.com.fiap.soat7.domain.types.StatusPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedido")
@Getter
@Setter
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String cpf;
    private Date dataCadastro;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToMany
    @JoinTable(
            name = "PedidoProduto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<ProdutoEntity> produtoList;
    private String observacao;

    public PedidoEntity() {}

    public PedidoEntity(Pedido pedido) {
        this.id = pedido.getId();
        this.cpf = pedido.getCpf();
        this.dataCadastro = pedido.getDataCadastro();
        this.status = pedido.getStatus();
        this.produtoList = pedido.getIdProdutoList().stream().map(ProdutoEntity::new).toList();
        this.observacao = pedido.getObservacao();
    }

    public Pedido toPedido () {
        return new Pedido(this.id, this.cpf, this.dataCadastro, this.status, this.produtoList.stream().map(ProdutoEntity::getId).toList(), this.observacao );
    }
}
