package br.com.fiap.soat7.application.usecases.produto;

import br.com.fiap.soat7.application.gateways.ProdutoGateway;
import br.com.fiap.soat7.domain.entity.Produto;

public class AdicionarProdutoInterector {

    private ProdutoGateway produtoGateway;


    public AdicionarProdutoInterector(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoGateway.adicionarProduto(produto);
    }
}
