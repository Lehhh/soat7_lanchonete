package br.com.fiap.soat7.domain.adapters.services;

import br.com.fiap.soat7.domain.dto.PedidoDTO;
import br.com.fiap.soat7.domain.model.Pedido;
import br.com.fiap.soat7.domain.ports.interfaces.PedidoServicePort;
import br.com.fiap.soat7.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.soat7.domain.types.StatusPedido;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PedidoServiceImpl implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    private final ModelMapper modelMapper;

    public PedidoServiceImpl(PedidoRepositoryPort pedidoRepositoryPort, ModelMapper modelMapper) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.modelMapper = modelMapper;
        setupModelMapper(this.modelMapper);
    }

    @Override
    public Pedido adicionarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido.setDataCadastro(new Date());
        pedido.setStatus(StatusPedido.RECEBIDO);
        return this.pedidoRepositoryPort.save(pedido);
    }

    @Override
    public Pedido marcarComoPronto(Long id) {
        Pedido pedido = this.pedidoRepositoryPort.findById(id);
        pedido.setStatus(StatusPedido.PRONTO);
        return this.pedidoRepositoryPort.save(pedido);
    }

    @Override
    public Pedido prepararPedido(Long id) {
        Pedido pedido = this.pedidoRepositoryPort.findById(id);
        pedido.setStatus(StatusPedido.EM_PREPARACAO);
        return this.pedidoRepositoryPort.save(pedido);
    }

    @Override
    public Pedido finalizarPedido(Long id) {
        Pedido pedido = this.pedidoRepositoryPort.findById(id);
        pedido.setStatus(StatusPedido.FINALIZADO);
        return this.pedidoRepositoryPort.save(pedido);
    }

    private void setupModelMapper(ModelMapper modelMapper) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(PedidoDTO.class, Pedido.class).addMappings(mapper ->
                mapper.map(PedidoDTO::getIdProdutoList, Pedido::setIdProdutoList)
        );
    }

}
