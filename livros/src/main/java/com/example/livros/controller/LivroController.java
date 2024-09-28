package com.example.livros.controller;

import com.example.livros.dto.LivroUsuarioDTO;
import com.example.livros.model.Livro;
import com.example.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro adicionarLivro(@RequestBody LivroUsuarioDTO livrousuarioDTO) {
        return livroService.adicionarLivro(livrousuarioDTO);
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable Long id) {
        return livroService.buscarLivroPorId(id);
    }
}
