package com.example.emprestimos.service;

import com.example.emprestimos.feign.EmprestimoListenerClient;
import com.example.emprestimos.feign.LivroClient;
import com.example.emprestimos.dto.LivroDTO;
import com.example.emprestimos.model.Emprestimo;
import com.example.emprestimos.rabbit.EmprestimoPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoListenerClient emprestimoListenerClient;

    @Autowired
    private LivroClient livroClient;

    @Autowired
    private EmprestimoPublisher emprestimoPublisher;

    public Emprestimo criarEmprestimo(Long livroId, Emprestimo emprestimo) {
        LivroDTO livro = livroClient.getLivroById(livroId);
        if (livro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
        } else {
            emprestimo.setLivroId(livroId);
            emprestimo.setLivroTitulo(livro.getTitulo());
            emprestimo.setLivroEdicao(livro.getEdicao());
            emprestimoPublisher.enviarEmprestimo(emprestimo);
            return emprestimo;
        }
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoListenerClient.getAllEmprestimos();
    }

    public Emprestimo buscarEmprestimoPorId(Long id) {
        return emprestimoListenerClient.getEmprestimosById(id);
    }
}