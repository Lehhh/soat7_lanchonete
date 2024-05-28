package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.infrastructure.adapters.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

}