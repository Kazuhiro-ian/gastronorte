package com.gastronorte.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "Formato de CPF inválido")
    @Column(unique = true)
    private String cpf;

    @PastOrPresent(message = "A data de nascimento não pode estar no futuro")
    @Column(name = "data_nasc")
    private LocalDate dataNascimento;
}