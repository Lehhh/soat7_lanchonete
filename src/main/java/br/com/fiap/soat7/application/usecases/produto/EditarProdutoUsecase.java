package br.com.fiap.soat7.application.usecases.produto;

import br.com.fiap.soat7.application.gateways.ProdutoGateway;
import br.com.fiap.soat7.domain.entity.Produto;

public class EditarProdutoUsecase {

    private ProdutoGateway produtoGateway;


    public EditarProdutoUsecase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto editarProduto(Long id,Produto produto) throws Exception {
        return produtoGateway.editarProduto(id,produto);
    }
}
