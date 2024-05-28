package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.infrastructure.adapters.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCpf(String cpf);

    List<ClienteEntity> findAll();
}
