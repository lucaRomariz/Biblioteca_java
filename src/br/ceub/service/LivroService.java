package br.ceub.service;
import java.util.List;

import br.ceub.model.Livro;
import br.ceub.repository.LivroRepository;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService() {
        this.livroRepository = new LivroRepository();
    }

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {
        return null;
    }

    public Livro buscarPorId(int id) {
        return null;
    }

    public List<Livro> buscarPorNome(String nome) {
        return null;
    }

    public List<Livro> listarTodos() {
        return null;
    }

    public void alterar(Livro livro) {
    }

    public void remover(int id) {
    }
}
