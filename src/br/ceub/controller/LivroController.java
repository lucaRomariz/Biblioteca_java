package br.ceub.controller;

import java.util.List;

import br.ceub.model.Livro;
import br.ceub.service.LivroService;

public class LivroController {
    private LivroService livroService;

    public LivroController() {
        this.livroService = new LivroService();
    }

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    public void cadastrar(Livro livro) {
    	if (livro == null) {
    		System.out.println("O livro não está registrado");
    	} else {
    		livroService.cadastrar(livro);
    	}
    }

    public Livro buscarPorId(int id) {
    	if (id <= 0) {
    		System.out.println("Id inválido");
    		return null;
    	} else {
    		return livroService.buscarPorId(id);
    	}
    }

    public List<Livro> buscarPorNome(String nome) {
    	if (nome == null) {
    		System.out.println("O nome não está registrado");
    		return null;
    	} else {
    		return livroService.buscarPorNome(nome);
    	}
    }

    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    public void alterar(Livro livro) {
    	if (livro == null) {
    		System.out.println("O livro não está registrado");
    	} else {
    		livroService.alterar(livro);
    	}
    }

    public void remover(int id) {
    	if (id <= 0) {
    		System.out.println("Id inválido");
    	} else {
    		livroService.remover(id);
    	}
    }
}
