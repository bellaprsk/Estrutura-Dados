package exercicio04;

import java.util.LinkedList;
import java.util.Scanner;
import org.w3c.dom.Node;

public class index {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class NodeLinkedList {
    private static LinkedList<Node> nodeList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Finalizar");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        System.out.println("Programa encerrado.");
    }

    private static void cadastrar() {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        Node novoNode = new Node(nome);
        nodeList.add(novoNode);
        System.out.println("Nome cadastrado com sucesso.");
    }

    private static void listar() {
        if (nodeList.isEmpty()) {
            System.out.println("Não há nomes cadastrados.");
        } else {
            System.out.println("Nomes cadastrados:");
            for (Node node : nodeList) {
                System.out.println(node.data);
            }
        }
    }
}
