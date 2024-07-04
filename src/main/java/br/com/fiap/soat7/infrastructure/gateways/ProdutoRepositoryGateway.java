package br.com.fiap.soat7.infrastructure.gateways;

import br.com.fiap.soat7.application.gateways.ProdutoGateway;
import br.com.fiap.soat7.domain.entity.Produto;
import br.com.fiap.soat7.domain.types.Categoria;
import br.com.fiap.soat7.infrastructure.persistence.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProdutoRepositoryGateway implements ProdutoGateway {

    @Autowired
    private ModelMapper modelMapper;

    private final ProdutoRepository repository;

    public ProdutoRepositoryGateway(ProdutoRepository repository) {
        this.repository = repository;
    }


    @Override
    public Produto adicionarProduto(Produto produto) {
        return this.repository.save(produto);
    }

    @Override
    public Produto editarProduto(Long id, Produto produto) throws Exception {
        produto.setId(id);
        return this.repository.save(produto);
    }

    @Override
    public void excluir(Long id) throws Exception {
        repository.delete(id);
    }

    @Override
    public List<Produto> consultarPorCategoria(Categoria categoria) {
        return repository.consultarPorCategoria(categoria);
    }
}
