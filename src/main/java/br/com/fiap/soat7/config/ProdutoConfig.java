package br.com.fiap.soat7.config;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.application.gateways.ProdutoGateway;
import br.com.fiap.soat7.application.usecases.pedido.FinalizarPedidoInterector;
import br.com.fiap.soat7.application.usecases.pedido.MarcarPedidoProntoInterector;
import br.com.fiap.soat7.application.usecases.pedido.PrepararPedidoInterector;
import br.com.fiap.soat7.application.usecases.produto.AdicionarProdutoInterector;
import br.com.fiap.soat7.application.usecases.produto.ConsultarProdutoCategoriaInterector;
import br.com.fiap.soat7.application.usecases.produto.EditarProdutoInterector;
import br.com.fiap.soat7.application.usecases.produto.ExcluirProdutoInterector;
import br.com.fiap.soat7.infrastructure.gateways.PedidoRepositoryGateway;
import br.com.fiap.soat7.infrastructure.gateways.ProdutoRepositoryGateway;
import br.com.fiap.soat7.infrastructure.persistence.PedidoRepository;
import br.com.fiap.soat7.infrastructure.persistence.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {

    @Bean
    AdicionarProdutoInterector adicionarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new AdicionarProdutoInterector(produtoGateway);
    }

    @Bean
    ConsultarProdutoCategoriaInterector consultarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new ConsultarProdutoCategoriaInterector(produtoGateway);
    }

    @Bean
    EditarProdutoInterector editarProdutoUseCase(ProdutoGateway produtoGateway) {
        return new EditarProdutoInterector(produtoGateway);
    }

    @Bean
    ExcluirProdutoInterector excluirProdutoUseCase(ProdutoGateway produtoGateway) {
        return new ExcluirProdutoInterector(produtoGateway);
    }

    @Bean
    ProdutoGateway produtoGateway(ProdutoRepository produtoRepository) {
        return new ProdutoRepositoryGateway(produtoRepository);
    }
}
