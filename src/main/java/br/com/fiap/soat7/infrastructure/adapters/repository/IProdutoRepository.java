package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.domain.model.Categoria;
import br.com.fiap.soat7.infrastructure.adapters.entity.ClienteEntity;
import br.com.fiap.soat7.infrastructure.adapters.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProdutoRepository  extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByCategoria(Categoria categoria);
}
