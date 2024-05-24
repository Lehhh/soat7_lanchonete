package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.infrastructure.adapters.entity.ClienteEntity;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository  extends JpaRepository<ProdutoEntity, Long> {
}
