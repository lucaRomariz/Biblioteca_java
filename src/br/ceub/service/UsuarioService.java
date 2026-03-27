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
        return usuarioRepository.salvar(usuario);
    }

    public Usuario buscarPorId(int id) {
        Usuario usuario = usuarioRepository.buscarPorId(id);
        if(usuario == null) {
        	throw new RuntimeException("Usuário não encontrado pelo ID fornecido!");
        }
        return usuario;
    }

    public Usuario buscarPorCpf(String cpf) {
        Usuario usuario = usuarioRepository.buscarPorCpf(cpf);
        if(usuario == null) {
        	throw new RuntimeException("Usuário não encontrado pelo cpf fornecido!");
        }
        return usuario;	
    }

    public Usuario buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);
        if(usuario == null) {
        	throw new RuntimeException("Usuário não encontrado!");
        }
        return usuario;
    }

    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> usuario = usuarioRepository.buscarPorNome(nome);
        
        if(usuario == null) {
        	throw new RuntimeException("Usuário não encontrado!");
        }
        
        return usuario;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public void alterar(Usuario usuario) {
    	usuarioRepository.atualizar(usuario);
    }

    public void remover(int id) {
    	usuarioRepository.deletar(id);
    }
}
