package com.gastronorte.backend.repository;

import com.gastronorte.backend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // O Spring Data JPA cria a query automaticamente ("SELECT count(p) > 0 FROM Paciente p WHERE p.cpf = ?1")
    boolean existsByCpf(String cpf);
}