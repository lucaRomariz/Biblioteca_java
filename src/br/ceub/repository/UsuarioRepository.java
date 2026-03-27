package br.ceub.repository;
import java.util.ArrayList;
import java.util.List;
import br.ceub.model.Usuario;

public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public void salvar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public List<Usuario> listarTodos() {
        return listaUsuarios;
    }

    public Usuario buscarPorId(int id) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario u = listaUsuarios.get(i);
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public Usuario buscarPorCpf(String cpf) {
        for (Usuario u : listaUsuarios) {
            if (u.getCpf() != null) {
                if (u.getCpf().equals(cpf)) {
                    return u;
                }
            }
        }
        return null;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail() != null) {
                if (u.getEmail().equals(email)) {
                    return u;
                }
            }
        }
        return null;
    }

    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : listaUsuarios) {
            if (u.getNome() != null) {
                if (u.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    resultado.add(u);
                }
            }
        }
        return resultado;
    }

    public void atualizar(Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == usuario.getId()) {
                listaUsuarios.set(i, usuario);
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == id) {
                listaUsuarios.remove(i);
            }
        }
    }
}