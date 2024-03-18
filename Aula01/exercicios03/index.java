package exercicios03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class index {
    static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Pesquisar produtos por termo");
            System.out.println("4 - Alterar produto");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Finalizar");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    pesquisarProdutosPorTermo();
                    break;
                case 4:
                    alterarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 6:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);
    }

    static void cadastrarProduto() {
        System.out.println("Informe o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Informe o valor do produto:");
        double valor = scanner.nextDouble();

        Produto produto = new Produto(nome, valor);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso.");
    }

    static void listarProdutos() {
        System.out.println("\nLista de Produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    static void pesquisarProdutosPorTermo() {
        System.out.println("Informe o termo de pesquisa:");
        String termo = scanner.nextLine();

        System.out.println("\nResultados da Pesquisa:");
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(produto);
            }
        }
    }

    static void alterarProduto() {
        System.out.println("Informe o nome do produto a ser alterado:");
        String nomeAntigo = scanner.nextLine();

        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getNome().equalsIgnoreCase(nomeAntigo)) {
                System.out.println("Informe o novo nome do produto:");
                String novoNome = scanner.nextLine();
                System.out.println("Informe o novo valor do produto:");
                double novoValor = scanner.nextDouble();

                produto.setNome(novoNome);
                produto.setValor(novoValor);

                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    static void removerProduto() {
        System.out.println("Informe o nome do produto a ser removido:");
        String nomeRemover = scanner.nextLine();

        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getNome().equalsIgnoreCase(nomeRemover)) {
                iterator.remove();
                System.out.println("Produto removido com sucesso.");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}

class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Valor: " + valor;
    }
}
