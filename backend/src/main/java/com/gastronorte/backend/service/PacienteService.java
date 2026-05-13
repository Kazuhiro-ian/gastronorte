package com.gastronorte.backend.service;

import com.gastronorte.backend.model.Paciente;
import com.gastronorte.backend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    public Paciente cadastrar(Paciente paciente) {

        if (paciente.getCpf() != null) {
            String cpfLimpo = paciente.getCpf().replaceAll("[^0-9]", "");
            paciente.setCpf(cpfLimpo);
        }

        if (repository.existsByCpf(paciente.getCpf())) {
            throw new RuntimeException("Já existe um paciente cadastrado com o CPF informado.");
        }

        return repository.save(paciente);
    }
}