package br.ceub.service;
import java.util.List;

import br.ceub.model.Usuario;
import br.ceub.repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
        return null;
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
