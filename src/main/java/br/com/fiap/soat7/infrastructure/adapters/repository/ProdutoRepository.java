package br.com.fiap.soat7.infrastructure.adapters.repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import br.com.fiap.soat7.domain.model.Produto;
import br.com.fiap.soat7.domain.ports.repositories.ProdutoRepositoryPort;
import br.com.fiap.soat7.domain.types.Categoria;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;


@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final IProdutoRepository repository;

    public ProdutoRepository(IProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto save(Produto produto) {

        ProdutoEntity produtoEntity = new ProdutoEntity(produto);

        try {
            ProdutoEntity produtoSalvo = this.repository.save(produtoEntity);
            if(Objects.nonNull(produtoSalvo)) {
                produto.setId(produtoSalvo.getId());
            }
            return produto;
        } catch (Exception e) {
            String message = "Erro ao salvar os valores informados. Verifique as valores enviados.";
            if (e.getMessage().contains("Unique index or primary key violation")){
                message = "Nome do produto já existente.";
            }
            throw new DataIntegrityViolationException(message);
        }
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
