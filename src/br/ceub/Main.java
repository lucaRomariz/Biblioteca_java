package br.ceub;
import java.util.List;
import java.util.Scanner;
import br.ceub.controller.LivroController;
import br.ceub.model.Livro;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA =====\n");
        Scanner scanner = new Scanner(System.in);
        LivroController livroController = new LivroController();
        boolean continuar = true;

        while (continuar) {
            System.out.println("1 -- cadastrar um livro");
            System.out.println("2 -- listar todos os livros");
            System.out.println("3 -- buscar um livro pelo nome");
            System.out.println("4 -- sair do sistema");
            System.out.print("escolha entre entre as opções de 1 a 4: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("cadastro de livro");
                System.out.print("digite o id: ");
                int id = scanner.nextInt();

                System.out.print("digite o nome do livro: ");
                String nome = scanner.nextLine();

                System.out.print("digite o autor: ");
                String autor = scanner.nextLine();

                System.out.print("digite o edição: ");
                int edicao = scanner.nextInt();

                System.out.print("digite a quantidade: ");
                int quantidade = scanner.nextInt();

                Livro livro = new Livro(id, nome, autor, edicao, quantidade);
                livroController.cadastrar(livro);
                System.out.println("livro cadastrado com sucesso");

            } else if (opcao == 2) {
                System.out.println("lista de livros");

                List<Livro> listaLivros = livroController.listarTodos();
                for (Livro l : listaLivros) {
                    System.out.println(l.getId() + " - " + l.getNome());
                }
            } else if (opcao == 3) {
                System.out.println("buscar livro");

                System.out.print("digite o nome do livro: ");
                String nomeBusca = scanner.nextLine();

                List<Livro> livros = livroController.buscarPorNome(nomeBusca);
                if (livros != null && livros.isEmpty()) {
                    for (Livro l : livros) {
                        System.out.println("livro encontrado: " + l.getNome());
                    }
                } else {
                    System.out.println("livro não encontrado");
                }               
            } else if (opcao == 4) {
                continuar = false;
                System.out.println("saindo do sistema");
            } else {
                System.out.println("opção inválida");
            }
        }
        scanner.close();
    }
}