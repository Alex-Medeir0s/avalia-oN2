package com.br.controller;

import com.br.model.Tarefa;
import com.br.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;


    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setStatus("Pendente");
        return tarefaRepository.save(tarefa);
    }

    
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarStatus(@PathVariable Long id, @RequestBody String novoStatus) {
        return tarefaRepository.findById(id).map(tarefa -> {
            tarefa.setStatus(novoStatus);
            tarefaRepository.save(tarefa);
            return ResponseEntity.ok(tarefa);
        }).orElse(ResponseEntity.notFound().build());
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
