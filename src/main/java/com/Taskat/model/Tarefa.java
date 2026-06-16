package com.Taskat.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @NotNull(message = "O status é obrigatório")
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDENTE;

    private LocalDate dtVencimento;

    private LocalDate dtConclusao;

//    public Tarefa() {
//    }
//
//    public Tarefa(Long id, String titulo, String descricao, Status status, LocalDate dtVencimento, LocalDate dtConclusao) {
//        this.id = id;
//        this.titulo = titulo;
//        this.descricao = descricao;
//        this.status = status;
//        this.dtVencimento = dtVencimento;
//        this.dtConclusao = dtConclusao;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitulo() {
//        return titulo;
//    }
//
//    public void setTitulo(String titulo) {
//        this.titulo = titulo;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public LocalDate getDtVencimento() {
//        return dtVencimento;
//    }
//
//    public void setDtVencimento(LocalDate dtVencimento) {
//        this.dtVencimento = dtVencimento;
//    }
//
//    public LocalDate getDtConclusao() {
//        return dtConclusao;
//    }
//
//    public void setDtConclusao(LocalDate dtConclusao) {
//        this.dtConclusao = dtConclusao;
//    }
}

