package com.example.livros.dto;

public class LivroUsuarioDTO {

    private String titulo;
    private String autor;
    private String edicao;
    private Long usuarioId;

    public LivroUsuarioDTO() {}

    public LivroUsuarioDTO(String titulo, String autor, String edicao, Long usuarioId) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.usuarioId = usuarioId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String isbn) {
        this.edicao = isbn;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
