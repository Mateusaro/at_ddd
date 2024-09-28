package com.example.emprestimos.feign;

import com.example.emprestimos.dto.LivroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "livros", url = "http://localhost:8081/livros")
public interface LivroClient {

    @GetMapping("/{id}")
    LivroDTO getLivroById(@PathVariable("id") Long id);
}
