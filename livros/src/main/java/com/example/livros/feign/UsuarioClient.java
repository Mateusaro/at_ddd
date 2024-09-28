package com.example.livros.feign;

import com.example.livros.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarioClient", url = "http://localhost:8080")
public interface UsuarioClient {
    @GetMapping("/usuarios/{id}")
    Usuario getUserById(@PathVariable("id") Long id);
}
