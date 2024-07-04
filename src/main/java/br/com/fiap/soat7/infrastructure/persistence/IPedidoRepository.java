package br.com.fiap.soat7.infrastructure.persistence;

import br.com.fiap.soat7.infrastructure.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

}