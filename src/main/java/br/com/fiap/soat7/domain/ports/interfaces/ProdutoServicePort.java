package br.com.fiap.soat7.domain.ports.interfaces;

import br.com.fiap.soat7.domain.dto.ProdutoDTO;
import br.com.fiap.soat7.domain.model.Categoria;
import br.com.fiap.soat7.domain.model.Produto;

import java.util.List;

public interface ProdutoServicePort {

    Produto adicionarProduto (ProdutoDTO cliente);

    void editarProduto (Long id, ProdutoDTO produtoDTO) throws Exception;

    void excluir (Long id) throws Exception;

    List<Produto> consultarPorCategoria(Categoria categoria);
}
