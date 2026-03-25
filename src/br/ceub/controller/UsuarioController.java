package br.ceub.controller;

import java.util.List;

import br.ceub.model.Usuario;
import br.ceub.service.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void cadastrar(Usuario usuario) {
    	if (usuario == null) {
    		System.out.println("O usuário não está preenchido");
    	} else {
    		usuarioService.cadastrar(usuario);
    	}
    }

    public Usuario buscarPorId(int id) {
    	if (id <= 0) {
    		System.out.println("Id inválido");
    		return null;
    	} else {
    		return usuarioService.buscarPorId(id);
    	} 
    }

    public Usuario buscarPorCpf(String cpf) {
    	if (cpf == null) {
    		System.out.println("O cpf não está preenchido");
    		return null;
    	} else {
    		return usuarioService.buscarPorCpf(cpf);
    	}
    }

    public Usuario buscarPorEmail(String email) {
    	if (email == null) {
    		System.out.println("O email não está preenchido");
    		return null;
    	} else {
    		return usuarioService.buscarPorEmail(email);
    	}
    }

    public List<Usuario> buscarPorNome(String nome) {
    	if (nome == null) {
    		System.out.println("O nome não está preenchido");
    		return null;
    	} else {
    		return usuarioService.buscarPorNome(nome);
    	}
    }

    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    public void alterar(Usuario usuario) {
    	if (usuario == null) {
    		System.out.println("O usuário não está preenchido");
    	} else {
    		usuarioService.alterar(usuario);
    	}
    }

    public void remover(int id) {
    	if (id <= 0) {
    		System.out.println("Id inválido");
    	} else {
    		usuarioService.remover(id);
    	}
    }
}
