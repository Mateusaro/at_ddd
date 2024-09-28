package com.example.emprestimos_listener.controller;

import com.example.emprestimos_listener.model.Emprestimo;
import com.example.emprestimos_listener.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos_listener")
public class EmprestimoListenerController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> buscarTodosEmprestimos() {
        return emprestimoService.buscarTodosEmprestimos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscarEmprestimoPorId(@PathVariable Long id) {
        return emprestimoService.buscarEmprestimoPorId(id);
    }
}
