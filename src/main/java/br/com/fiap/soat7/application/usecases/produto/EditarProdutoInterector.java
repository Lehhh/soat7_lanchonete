package br.com.fiap.soat7.application.usecases.produto;

import br.com.fiap.soat7.application.gateways.ProdutoGateway;
import br.com.fiap.soat7.domain.entity.Produto;

public class EditarProdutoInterector {

    private ProdutoGateway produtoGateway;


    public EditarProdutoInterector(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto editarProduto(Long id,Produto produto) throws Exception {
        return produtoGateway.editarProduto(id,produto);
    }
}
