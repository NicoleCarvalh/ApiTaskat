package com.Taskat.controller;

import com.Taskat.model.Tarefa;
import com.Taskat.service.TarefaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarefas")
@Tag(name = "Tarefas", description = "Endpoints de gerenciamento de tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listarTodas(){

        return tarefaService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa tarefa){

        Tarefa salva = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(201).body(salva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa){

        Tarefa atualizada = tarefaService.atualizar(id, tarefa);
        return ResponseEntity.ok(atualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){

        Tarefa tarefa = tarefaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada com o ID: " + id));
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Tarefa> concluirTarefa(@PathVariable Long id) {

        Tarefa tarefaAtualizada = tarefaService.atualizarStatus(id, "CONCLUIDA");
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @PatchMapping("/{id}/reabrir")
    public ResponseEntity<Tarefa> reabrirTarefa(@PathVariable Long id) {

        Tarefa tarefaReaberta = tarefaService.reabrirTarefa(id);

        return ResponseEntity.ok(tarefaReaberta);
    }
}
