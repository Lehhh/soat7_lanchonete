package br.com.fiap.soat7.application.adapters.controller;

import br.com.fiap.soat7.domain.dto.ProdutoDTO;
import br.com.fiap.soat7.domain.model.Categoria;
import br.com.fiap.soat7.domain.model.Produto;
import br.com.fiap.soat7.domain.ports.interfaces.ProdutoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto) throws Exception {

        produtoServicePort.editarProduto(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody ProdutoDTO dto){
        Produto produto = produtoServicePort.adicionarProduto(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) throws Exception {
        produtoServicePort.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable Categoria categoria) {
        List<Produto> produtos = produtoServicePort.consultarPorCategoria(categoria);
        return ResponseEntity.ok(produtos);
    }

}
