package com.example.emprestimos.controller;

import com.example.emprestimos.model.Emprestimo;
import com.example.emprestimos.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/{livroId}")
    public Emprestimo criarEmprestimo(@PathVariable Long livroId, @RequestBody Emprestimo emprestimo) {
        return emprestimoService.criarEmprestimo(livroId, emprestimo);
    }

    @GetMapping
    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoService.listarTodosEmprestimos();
    }

    @GetMapping("/{id}")
    public Emprestimo buscarEmprestimoPorId(@PathVariable Long id) {
        return emprestimoService.buscarEmprestimoPorId(id);
    }

}
