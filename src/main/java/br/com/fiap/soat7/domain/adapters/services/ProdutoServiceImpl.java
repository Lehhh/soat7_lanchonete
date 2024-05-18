package br.com.fiap.soat7.domain.adapters.services;

import br.com.fiap.soat7.domain.dto.ProdutoDTO;
import br.com.fiap.soat7.domain.model.Categoria;
import br.com.fiap.soat7.domain.model.Produto;
import br.com.fiap.soat7.domain.ports.interfaces.ProdutoServicePort;
import br.com.fiap.soat7.domain.ports.repositories.ProdutoRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoServiceImpl(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }


    @Override
    public Produto adicionarProduto(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setCategoria(dto.getCategoria());
        produto.setPreco(dto.getPreco());
        produto.setDescricao(dto.getDescricao());
        produto.setImagem(dto.getImagem());
        return this.produtoRepositoryPort.save(produto);
    }

    @Override
    public void editarProduto(Long id, ProdutoDTO produtoDTO) throws Exception {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setCategoria(produtoDTO.getCategoria());
        produto.setPreco(produtoDTO.getPreco());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setImagem(produtoDTO.getImagem());
        produtoRepositoryPort.atualizar(id, produto);
    }

    @Override
    public void excluir(Long id) throws Exception {
        produtoRepositoryPort.delete(id);
    }

    @Override
    public List<Produto> consultarPorCategoria(Categoria categoria) {
        return produtoRepositoryPort.consultarPorCategoria(categoria);
    }
}
