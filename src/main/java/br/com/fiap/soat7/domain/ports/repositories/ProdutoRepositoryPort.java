package br.com.fiap.soat7.domain.ports.repositories;

import br.com.fiap.soat7.domain.model.Categoria;
import br.com.fiap.soat7.domain.model.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {

    Produto save (Produto produto);

    void delete (Long id) throws Exception;

    void atualizar (Long id, Produto produto) throws Exception;

    Produto buscarPeloId(Long id) throws Exception;

    List<Produto> consultarPorCategoria(Categoria categoria);
}
