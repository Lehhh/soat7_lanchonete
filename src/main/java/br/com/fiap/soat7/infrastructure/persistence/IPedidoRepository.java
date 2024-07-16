package br.com.fiap.soat7.infrastructure.persistence;

import br.com.fiap.soat7.infrastructure.persistence.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

    @Query("SELECT p FROM PedidoEntity p JOIN FETCH p.produtoList WHERE p.id = :id")
    Optional<PedidoEntity> findByIdWithProduto(@Param("id") Long id);
}