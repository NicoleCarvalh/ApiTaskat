package com.Taskat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

//Cria getters e setter para todos os atributos - lombok
@Data

// Cria constructor para todos os atributos
@AllArgsConstructor

// Cria constructor vazio
@NoArgsConstructor


public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Validações do Spring Validation
    @NotBlank(message = "O campo título é obrigatório")
    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDENTE;

    private LocalDateTime dtVencimento;

    private LocalDateTime dtConclusao;

    @PrePersist
    protected void onCreate() {
        if (this.status == null) {
            this.status = Status.PENDENTE;
        }
    }
}

