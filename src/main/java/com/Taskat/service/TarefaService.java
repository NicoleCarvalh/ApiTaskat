package com.Taskat.service;

import com.Taskat.model.Tarefa;
import com.Taskat.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Taskat.model.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas(){

        return tarefaRepository.findAll();
    }

    public Tarefa criarTarefa(Tarefa tarefa){

        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa tarefa){
        Tarefa tarefaExist = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException());

        tarefaExist.setTitulo(tarefa.getTitulo());
        tarefaExist.setDescricao(tarefa.getDescricao());
        tarefaExist.setStatus(tarefa.getStatus());
        tarefaExist.setDtVencimento(tarefa.getDtVencimento());
        tarefaExist.setDtConclusao(tarefa.getDtConclusao());

        return tarefaRepository.save(tarefaExist);
    }

    // Verificar optional
    public Optional<Tarefa> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public void deletar(Long id){
        tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException());

        tarefaRepository.deleteById(id);
    }

    public Tarefa atualizarStatus(Long id, String status) {
        Tarefa tarefa = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada com o ID: " + id));

        tarefa.setStatus(validarStatus(status));

        return tarefaRepository.save(tarefa);
    }

    private Status validarStatus(String status){
        return Arrays.stream(Status.values())
                .filter(s -> s.name().equalsIgnoreCase(status))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Status inválido: " + status));
    }

    public Tarefa reabrirTarefa(Long id){

        Tarefa tarefa = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada com o ID: " + id));

        if (tarefa.getStatus() == Status.PENDENTE) {
            throw new IllegalArgumentException("Esta tarefa já está pendente/aberta!");
        }

        tarefa.setStatus(Status.PENDENTE);
        tarefa.setDtConclusao(null);

        return tarefaRepository.save(tarefa);
    }
}
