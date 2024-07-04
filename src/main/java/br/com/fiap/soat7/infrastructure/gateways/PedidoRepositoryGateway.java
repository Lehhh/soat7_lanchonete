package br.com.fiap.soat7.infrastructure.gateways;

import br.com.fiap.soat7.application.gateways.PedidoGateway;
import br.com.fiap.soat7.domain.entity.Pedido;
import br.com.fiap.soat7.domain.types.StatusPedido;
import br.com.fiap.soat7.infrastructure.persistence.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PedidoRepositoryGateway implements PedidoGateway {

    private final PedidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public PedidoRepositoryGateway(PedidoRepository repository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Pedido adicionarPedido(Pedido pedido) {
        pedido.setDataCadastro(new Date());
        this.checkoutMercadoPago(pedido);
        pedido.setStatus(StatusPedido.RECEBIDO);
        return this.repository.save(pedido);
    }

    @Override
    public Pedido marcarComoPronto(Long id) {
        Pedido pedido = this.repository.findById(id);
        pedido.setStatus(StatusPedido.PRONTO);
        return this.repository.save(pedido);
    }

    @Override
    public Pedido prepararPedido(Long id) {
        Pedido pedido = this.repository.findById(id);
        pedido.setStatus(StatusPedido.EM_PREPARACAO);
        return this.repository.save(pedido);
    }

    @Override
    public Pedido finalizarPedido(Long id) {
        Pedido pedido = this.repository.findById(id);
        pedido.setStatus(StatusPedido.FINALIZADO);
        return this.repository.save(pedido);
    }

    @Override
    public List<Pedido> buscarPedidos() {
        return this.repository.findAll();
    }

    private boolean checkoutMercadoPago(Pedido pedido){
        return true;
    }

}
