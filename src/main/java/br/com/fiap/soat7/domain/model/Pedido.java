package br.com.fiap.soat7.domain.model;

import br.com.fiap.soat7.domain.types.StatusPedido;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Pedido {

    private Long id;
    private String cpf;
    @Schema(type = "string", pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataCadastro;
    private StatusPedido status;
    private List<Produto> idProdutoList;
    private String observacao;

    public Pedido() {
    }

    public Pedido(Long id, String cpf, Date dataCadastro, StatusPedido status, List<ProdutoEntity> idProdutoList, String observacao) {
        this.id = id;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.idProdutoList = idProdutoList.stream().map(Produto::new).toList();
        this.observacao = observacao;
    }
}
