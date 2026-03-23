package br.ceub.service;



import java.util.List;

import br.ceub.model.Emprestimo;
import br.ceub.repository.EmprestimoRepository;
import br.ceub.repository.LivroRepository;
import br.ceub.repository.UsuarioRepository;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private UsuarioRepository usuarioRepository;
    private LivroRepository livroRepository;
    private static int proximoId = 1;

    public EmprestimoService() {
        this.emprestimoRepository = new EmprestimoRepository();
        this.usuarioRepository = new UsuarioRepository();
        this.livroRepository = new LivroRepository();
    }

    public EmprestimoService(EmprestimoRepository emprestimoRepository, 
                            UsuarioRepository usuarioRepository, 
                            LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo realizarEmprestimo(int usuarioId, int livroId, int diasEmprestimo) {
        return null;
    }

    public void devolverLivro(int emprestimoId) {
    }

    public List<Emprestimo> buscarEmprestimosDoUsuario(int usuarioId) {
        return null;
    }

    public List<Emprestimo> buscarEmprestimosAtivosDoUsuario(int usuarioId) {
        return null;
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return null;
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return null;
    }

    public Emprestimo buscarPorId(int id) {
        return null;
    }

    public boolean verificarAtraso(int emprestimoId) {
        return false;
    }
}
