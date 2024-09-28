package com.example.livros.service;

import com.example.livros.dto.LivroUsuarioDTO;
import com.example.livros.feign.UsuarioClient;
import com.example.livros.model.Livro;
import com.example.livros.model.Usuario;
import com.example.livros.rabbit.LivroPublisher;
import com.example.livros.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroPublisher livroPublisher;

    @Autowired
    private UsuarioClient usuarioClient;

    @Transactional
    public Livro adicionarLivro(LivroUsuarioDTO livrousuarioDTO) {
        Usuario usuario = usuarioClient.getUserById(livrousuarioDTO.getUsuarioId());

        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        } else {
            System.out.println("Livro adicionado por: " + usuario.getNome());
            Livro livro = new Livro();
            livro.setTitulo(livrousuarioDTO.getTitulo());
            livro.setAutor(livrousuarioDTO.getAutor());
            livro.setEdicao(livrousuarioDTO.getEdicao());
            livro.setUsuarioId(livrousuarioDTO.getUsuarioId());

            Livro savedLivro = livroRepository.save(livro);
            livroPublisher.enviarLivroParaFila(savedLivro);

            return savedLivro;
        }
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(Long id) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        return livroOpt.orElse(null); // Retorna null se o livro não for encontrado
    }
}
