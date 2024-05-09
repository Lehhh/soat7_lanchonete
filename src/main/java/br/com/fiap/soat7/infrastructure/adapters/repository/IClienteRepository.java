package br.com.fiap.soat7.infrastructure.adapters.repository;

import br.com.fiap.soat7.infrastructure.adapters.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCpf(String cpf);
}
