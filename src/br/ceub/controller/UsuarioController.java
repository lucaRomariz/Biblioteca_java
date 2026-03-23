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
    }

    public Usuario buscarPorId(int id) {
        return null;
    }

    public Usuario buscarPorCpf(String cpf) {
        return null;
    }

    public Usuario buscarPorEmail(String email) {
        return null;
    }

    public List<Usuario> buscarPorNome(String nome) {
        return null;
    }

    public List<Usuario> listarTodos() {
        return null;
    }

    public void alterar(Usuario usuario) {
    }

    public void remover(int id) {
    }
}
