package br.com.fiap.soat7.domain.adapters.services;

import br.com.fiap.soat7.domain.dto.ProdutoDTO;
import br.com.fiap.soat7.domain.types.Categoria;
import br.com.fiap.soat7.domain.model.Produto;
import br.com.fiap.soat7.domain.ports.interfaces.ProdutoServicePort;
import br.com.fiap.soat7.domain.ports.repositories.ProdutoRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoServicePort {

    @Autowired
    private ModelMapper modelMapper;

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoServiceImpl(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }


    @Override
    public Produto adicionarProduto(ProdutoDTO dto) {
        Produto produto = modelMapper.map(dto, Produto.class);
        return this.produtoRepositoryPort.save(produto);
    }

    @Override
    public Produto editarProduto(Long id, ProdutoDTO produtoDTO) throws Exception {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto.setId(id);

        return this.produtoRepositoryPort.save(produto);
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
