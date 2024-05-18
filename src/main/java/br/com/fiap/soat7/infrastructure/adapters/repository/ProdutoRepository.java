package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.domain.model.Categoria;
import br.com.fiap.soat7.domain.model.Produto;
import br.com.fiap.soat7.domain.ports.repositories.ProdutoRepositoryPort;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final IProdutoRepository repository;

    public ProdutoRepository(IProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto save(Produto produto) {

        ProdutoEntity produtoEntity = new ProdutoEntity(produto);

         ProdutoEntity produtoSalvo = this.repository.save(produtoEntity);
        if(Objects.nonNull(produtoSalvo)) {
            produto.setId(produtoSalvo.getId());
        }
        return produto;
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("O produto não foi encontrado");
        }

    }

    @Override
    public void atualizar(Long id, Produto produto) throws Exception {
        Produto produtoSalvo = buscarPeloId(id);
        ProdutoEntity produtoEntity = new ProdutoEntity(produtoSalvo);
        if(Objects.nonNull(produtoEntity)) {
            produtoEntity.atualizar(produto);
        }
        this.repository.save(produtoEntity);
    }

    @Override
    public Produto buscarPeloId(Long id) throws Exception {
        Optional<ProdutoEntity> produto = repository.findById(id);

        if(Objects.isNull(produto.get())) {

            throw new Exception("Nenhum produto foi encontrado");
        }

        return produto.get().toProduto();
    }

    @Override
    public List<Produto> consultarPorCategoria(Categoria categoria) {
        return repository.findByCategoria(categoria).stream()
                .map(ProdutoEntity::toProduto)
                .toList();
    }

}
