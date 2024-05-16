package br.com.fiap.soat7.domain.ports.repositories;

import br.com.fiap.soat7.domain.dto.ProdutoDTO;
import br.com.fiap.soat7.domain.model.Cliente;
import br.com.fiap.soat7.domain.model.Produto;

public interface ProdutoRepositoryPort {

    Produto save (Produto produto);

    void delete (Long id) throws Exception;

    void atualizar (Long id, Produto produto) throws Exception;

    Produto buscarPeloId(Long id) throws Exception;
}
