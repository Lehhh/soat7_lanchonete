package br.com.fiap.soat7.application.usecases.produto;

import br.com.fiap.soat7.application.gateways.ProdutoGateway;

public class ExcluirProdutoInterector {

    private ProdutoGateway produtoGateway;


    public ExcluirProdutoInterector(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public void excluir(Long id) throws Exception {
        produtoGateway.excluir(id);
    }
}
