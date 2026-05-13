package com.gastronorte.backend.controller;

import com.gastronorte.backend.model.Paciente;
import com.gastronorte.backend.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:3000")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid Paciente paciente) {
        try {
            Paciente pacienteSalvo = service.cadastrar(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}