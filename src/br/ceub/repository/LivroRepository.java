package br.ceub.repository;
import java.util.ArrayList;
import java.util.List;
import br.ceub.model.Livro;

public class LivroRepository {

    private List<Livro> listaDeLivros = new ArrayList<>();

    public void salvar(Livro livro) {
        listaDeLivros.add(livro);
    }

    public List<Livro> listarTodos() {
        return listaDeLivros;
    }

    public Livro buscarPorId(int id) {
        for (Livro l : listaDeLivros) {
            if (l.getId() == id) {
                return l; 
            }
        }
        return null; 
    }

    public List<Livro> buscarPorNome(String nome) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro l : listaDeLivros) {
            if (l.getNome() != null && l.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public void atualizar(Livro livroAtualizado) {
        for (int i = 0; i < listaDeLivros.size(); i++) {
            if (listaDeLivros.get(i).getId() == livroAtualizado.getId()) {
                listaDeLivros.set(i, livroAtualizado);
            }
        }
    }

    public void deletar(int id) {
        for (int i = 0; i < listaDeLivros.size(); i++) {
            if (listaDeLivros.get(i).getId() == id) {
                listaDeLivros.remove(i);
            }
        }
    }
}