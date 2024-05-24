package br.com.fiap.soat7.domain.ports.interfaces;

import br.com.fiap.soat7.domain.dto.ProdutoDTO;
import br.com.fiap.soat7.domain.model.Produto;


public interface ProdutoServicePort {

    Produto adicionarProduto (ProdutoDTO cliente);

    Produto editarProduto (Long id, ProdutoDTO produtoDTO) throws Exception;

    void excluir (Long id) throws Exception;
}
