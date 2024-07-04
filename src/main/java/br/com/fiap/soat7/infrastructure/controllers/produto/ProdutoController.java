package br.com.fiap.soat7.infrastructure.controllers.produto;

import br.com.fiap.soat7.application.usecases.produto.AdicionarProdutoInterector;
import br.com.fiap.soat7.application.usecases.produto.ConsultarProdutoCategoriaInterector;
import br.com.fiap.soat7.application.usecases.produto.EditarProdutoInterector;
import br.com.fiap.soat7.application.usecases.produto.ExcluirProdutoInterector;
import br.com.fiap.soat7.domain.entity.Produto;
import br.com.fiap.soat7.domain.types.Categoria;
import br.com.fiap.soat7.infrastructure.controllers.produto.request.CategoriaRequest;
import br.com.fiap.soat7.infrastructure.controllers.produto.request.ProdutoRequest;
import br.com.fiap.soat7.infrastructure.controllers.produto.response.ProdutoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/produtos")
public class ProdutoController {

    private final AdicionarProdutoInterector adicionarProdutoInterector;

    private final ConsultarProdutoCategoriaInterector consultarProdutoCategoriaInterector;

    private final ExcluirProdutoInterector excluirProdutoInterector;

    private final EditarProdutoInterector editarProdutoInterector;

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoController(AdicionarProdutoInterector adicionarProdutoInterector,
                             ConsultarProdutoCategoriaInterector consultarProdutoCategoriaInterector,
                             ExcluirProdutoInterector excluirProdutoInterector,
                             EditarProdutoInterector editarProdutoInterector) {
        this.adicionarProdutoInterector = adicionarProdutoInterector;
        this.consultarProdutoCategoriaInterector = consultarProdutoCategoriaInterector;
        this.excluirProdutoInterector = excluirProdutoInterector;
        this.editarProdutoInterector = editarProdutoInterector;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id, @RequestBody ProdutoRequest request) throws Exception {
        Produto produtoRequest = modelMapper.map(request, Produto.class);
        Produto retorno = editarProdutoInterector.editarProduto(id,produtoRequest);
        ProdutoResponse response = modelMapper.map(retorno, ProdutoResponse.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionarProduto(@RequestBody ProdutoRequest request){
        Produto produtoRequest = modelMapper.map(request, Produto.class);
        Produto retorno = adicionarProdutoInterector.adicionarProduto(produtoRequest);
        ProdutoResponse response = modelMapper.map(retorno, ProdutoResponse.class);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) throws Exception {
        excluirProdutoInterector.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable CategoriaRequest request) throws Exception {
        Categoria categoria = modelMapper.map(request, Produto.class).getCategoria();
        List<Produto> produtos = consultarProdutoCategoriaInterector.consultarPorCategoria(categoria);
        return ResponseEntity.ok(produtos);
    }

}
