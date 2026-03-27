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
        return livroRepository.salvar(livro);
    }

    public Livro buscarPorId(int id) {
        Livro livro = livroRepository.buscarPorId(id);
        if(livro == null) {
        	throw new RuntimeException("Usuário não encontrado pelo ID fornecido!");
        }
        return livro;
    }

    public List<Livro> buscarPorNome(String nome) {
        List<Livro> livro = livroRepository.buscarPorNome(nome);
        
        if(livro == null) {
        	throw new RuntimeException("Usuário não encontrado pelo nome fornecido!");
        }
        return livro;
    }

    public List<Livro> listarTodos() {
    	return livroRepository.listarTodos();
    }

    public void alterar(Livro livro) {
    	livroRepository.atualizar(livro);
    }

    public void remover(int id) {
    	livroRepository.deletar(id);
    }
}
