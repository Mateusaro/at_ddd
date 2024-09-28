package com.example.emprestimos.feign;

import com.example.emprestimos.dto.LivroDTO;
import com.example.emprestimos.model.Emprestimo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "emprestimolistener", url = "http://localhost:8083/emprestimo_listener")
public interface EmprestimoListenerClient {

        @GetMapping("/{id}")
        Emprestimo getEmprestimosById(@PathVariable("id") Long id);

        @GetMapping("/")
        List<Emprestimo> getAllEmprestimos();
}


