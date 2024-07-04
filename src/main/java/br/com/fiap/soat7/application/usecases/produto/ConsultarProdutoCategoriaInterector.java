package br.com.fiap.soat7.application.usecases.produto;

import br.com.fiap.soat7.application.gateways.ProdutoGateway;
import br.com.fiap.soat7.domain.entity.Produto;
import br.com.fiap.soat7.domain.types.Categoria;

import java.util.List;

public class ConsultarProdutoCategoriaInterector {

    private ProdutoGateway produtoGateway;


    public ConsultarProdutoCategoriaInterector(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public List<Produto> consultarPorCategoria(Categoria categoria) throws Exception {
        return produtoGateway.consultarPorCategoria(categoria);
    }
}
