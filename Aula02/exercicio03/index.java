package exercicio03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class index {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Selecionar todos os produtos");
            System.out.println("3 - Quantidade de segmentos");
            System.out.println("4 - Alterar dados de um produto");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    selecionarTodos();
                    break;
                case 3:
                    quantidadeSegmentos();
                    break;
                case 4:
                    alterarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        System.out.println("Programa encerrado.");
    }

    private static void cadastrarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o segmento do produto:");
        String segmento = scanner.nextLine();

        // Você pode adicionar mais características aqui se desejar

        Produto produto = new Produto(nome, segmento);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void selecionarTodos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private static void quantidadeSegmentos() {
        Map<String, Integer> segmentos = new HashMap<>();
        for (Produto produto : produtos) {
            String segmento = produto.getSegmento();
            segmentos.put(segmento, segmentos.getOrDefault(segmento, 0) + 1);
        }
        System.out.println("Quantidade de produtos em cada segmento:");
        for (Map.Entry<String, Integer> entry : segmentos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " produtos");
        }
    }

    private static void alterarProduto() {
        System.out.println("Digite o nome do produto que deseja alterar:");
        String nome = scanner.nextLine();
        boolean encontrado = false;
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                System.out.println("Digite o novo nome do produto:");
                String novoNome = scanner.nextLine();
                System.out.println("Digite o novo segmento do produto:");
                String novoSegmento = scanner.nextLine();
                // Você pode adicionar mais características aqui se desejar
                produto.setNome(novoNome);
                produto.setSegmento(novoSegmento);
                System.out.println("Produto alterado com sucesso.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void removerProduto() {
        System.out.println("Digite o nome do produto que deseja remover:");
        String nome = scanner.nextLine();
        boolean removido = produtos.removeIf(produto -> produto.getNome().equals(nome));
        if (removido) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}

class Produto {
    private String nome;
    private String segmento;

    // Você pode adicionar mais características aqui se desejar

    public Produto(String nome, String segmento) {
        this.nome = nome;
        this.segmento = segmento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", segmento='" + segmento + '\'' +
                '}';
    }
}
