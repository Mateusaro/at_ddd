package com.example.emprestimos.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;


@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long livroId;
    private String livroTitulo;
    private String livroEdicao;
    private String nomeUsuario;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Long livroId, String livroTitulo, String livroEdicao, String nomeUsuario, String dataEmprestimo, String dataDevolucao) {
        this.livroId = livroId;
        this.livroTitulo = livroTitulo;
        this.livroEdicao = livroEdicao;
        this.nomeUsuario = nomeUsuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public String getLivroTitulo() {
        return livroTitulo;
    }

    public void setLivroTitulo(String livroTitulo) {
        this.livroTitulo = livroTitulo;
    }

    public String getLivroEdicao() {
        return livroEdicao;
    }

    public void setLivroEdicao(String livroEdicao) {
        this.livroEdicao = livroEdicao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}