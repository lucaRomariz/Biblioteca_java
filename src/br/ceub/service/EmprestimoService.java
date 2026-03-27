package br.ceub.service;



import java.util.List;
import java.util.ArrayList;

import br.ceub.model.Emprestimo;
import br.ceub.model.Livro;
import br.ceub.model.Usuario;
import br.ceub.repository.EmprestimoRepository;
import br.ceub.repository.LivroRepository;
import br.ceub.repository.UsuarioRepository;
import java.time.LocalDate;

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
    	
     Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
     if(usuario == null) {
    	 throw new RuntimeException("Usuário não encontrado!");
     }
     Livro livro = livroRepository.buscarPorId(livroId);
     if(livro == null) {
    	 throw new RuntimeException("Livro não encontrado!");
     }
     
     List<Emprestimo> todos = emprestimoRepository.listarTodos();
     for (Emprestimo e : todos) {
         if (e.getLivroId() == livroId && e.isAtivo()) {
             throw new RuntimeException("Livro já está emprestado e não foi devolvido!");
         }
     }

     Emprestimo novoEmprestimo = new Emprestimo();
     novoEmprestimo.setId(proximoId++);
     novoEmprestimo.setUsuarioId(usuarioId);
     novoEmprestimo.setLivroId(livroId);
     novoEmprestimo.setDataEmprestimo(LocalDate.now());
     novoEmprestimo.setDataDevolucaoPrevista(LocalDate.now().plusDays(diasEmprestimo));
     novoEmprestimo.setDataDevoluçaoReal(null);
     novoEmprestimo.setAtivo(true);

     return emprestimoRepository.salvar(novoEmprestimo);
 }
     

    public void devolverLivro(int emprestimoId) {
    	Emprestimo emprestimo = emprestimoRepository.buscarPorId(emprestimoId);
    	if (emprestimo == null) {
    		throw new RuntimeException("O empréstimo não foi encontrado!");
    	}
    	
    	if(!emprestimo.isAtivo()) {
    		throw new RuntimeException("O empréstimo já foi encerrado!");
    	}
    	
    	emprestimo.setDataDevoluçaoReal(LocalDate.now());
    	emprestimo.setAtivo(false);
    	emprestimoRepository.atualizar(emprestimo);
    }

    public List<Emprestimo> buscarEmprestimosDoUsuario(int usuarioId) {
        Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
        if(usuario == null) {
        	throw new RuntimeException("Usuário não encontrado!");
        }
        
        List<Emprestimo> resultado = new ArrayList<>();
        for (Emprestimo e : emprestimoRepository.listarTodos()) {
        	if(e.getUsuarioId() == usuarioId) {
        		resultado.add(e);
        	}
        }
        
        if (resultado.isEmpty()) {
            throw new RuntimeException("Nenhum empréstimo ativo encontrado para este usuário!");
        }
        
    	return resultado;
    }

    public List<Emprestimo> buscarEmprestimosAtivosDoUsuario(int usuarioId) {
        Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
        if(usuario == null) {
        	throw new RuntimeException("Usuário não encontrado!");
        }
        
        List<Emprestimo> ativos = new ArrayList<>();
        for(Emprestimo e : emprestimoRepository.listarTodos()) {
        	if (e.getUsuarioId() == usuarioId && e.isAtivo()) {
        		ativos.add(e);
        	}
        }
    	
        if (ativos.isEmpty()) {
            throw new RuntimeException("Nenhum empréstimo ativo encontrado para este usuário!");
        }
        
    	return ativos;
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        
    	List<Emprestimo> emprestimos = new ArrayList<>();
    	for(Emprestimo e : emprestimoRepository.listarTodos()) {
    		emprestimos.add(e);
    	}
    	
    	return emprestimos;
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        
    	List<Emprestimo> ativos = new ArrayList<>();
    	for(Emprestimo e : emprestimoRepository.listarTodos()) {
    		if(e.isAtivo()) {
    			ativos.add(e);
    		}
    	}
    	
    	return ativos;
    	
    }

    public Emprestimo buscarPorId(int id) {
        Emprestimo emprestimo = emprestimoRepository.buscarPorId(id);
        if(emprestimo == null) {
        	throw new RuntimeException("Empréstimo não encontrado!");
        }
    	
    	return emprestimo;
    }

    public boolean verificarAtraso(int emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.buscarPorId(emprestimoId);
        if (emprestimo == null) {
            throw new RuntimeException("Empréstimo não encontrado!");
        }

        if (!emprestimo.isAtivo()) {
            if (emprestimo.getDataDevoluçaoReal().isAfter(emprestimo.getDataDevolucaoPrevista())) {
                return true;
            } else {
                return false;
            }
        }

        if (LocalDate.now().isAfter(emprestimo.getDataDevolucaoPrevista())) {
            return true;
        } else {
            return false;
        }
    }
}

