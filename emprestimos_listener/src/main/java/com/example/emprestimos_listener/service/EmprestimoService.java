package com.example.emprestimos_listener.service;

import com.example.emprestimos_listener.model.Emprestimo;
import com.example.emprestimos_listener.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public void salvarEmprestimo(Emprestimo emprestimo) {
        emprestimoRepository.save(emprestimo);
        System.out.println("Emprestimo salvo no banco de dados: " + emprestimo);
    }

    public List<Emprestimo> buscarTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo buscarEmprestimoPorId(Long id) {
        return emprestimoRepository.findById(id).orElse(null);
    }
}
