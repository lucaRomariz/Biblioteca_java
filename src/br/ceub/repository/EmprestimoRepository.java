package br.ceub.repository;
import java.util.ArrayList;
import java.util.List;
import br.ceub.model.Emprestimo;

public class EmprestimoRepository {

    private List<Emprestimo> listaDeEmprestimos = new ArrayList<>();

    public void salvar(Emprestimo emprestimo) {
        listaDeEmprestimos.add(emprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return listaDeEmprestimos;
    }

    public Emprestimo buscarPorId(int id) {
        for (Emprestimo e : listaDeEmprestimos) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null; 
    }

    public List<Emprestimo> buscarPorUsuario(int idUsuario) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : listaDeEmprestimos) {
            if (e.getUsuarioId() == idUsuario) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Emprestimo> buscarEmprestimosAtivos(int idUsuario) {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : listaDeEmprestimos) {
            if (e.getUsuarioId() == idUsuario && e.isAtivo()) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : listaDeEmprestimos) {
            if (e.isAtivo()) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public void atualizar(Emprestimo emprestimoAtualizado) {
        for (int i = 0; i < listaDeEmprestimos.size(); i++) {
            if (listaDeEmprestimos.get(i).getId() == emprestimoAtualizado.getId()) {
                listaDeEmprestimos.set(i, emprestimoAtualizado);
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < listaDeEmprestimos.size(); i++) {
            if (listaDeEmprestimos.get(i).getId() == id) {
                listaDeEmprestimos.remove(i);
            }
        }
    }
}