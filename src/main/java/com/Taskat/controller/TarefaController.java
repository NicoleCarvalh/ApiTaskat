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





}
