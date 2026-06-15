package com.Taskat.service;

import com.Taskat.model.Tarefa;
import com.Taskat.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // Verificar optional
    public Optional<Tarefa> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public Tarefa atualizarTarefa(Long id, String status) {
        Tarefa tarefa =
    }
}
