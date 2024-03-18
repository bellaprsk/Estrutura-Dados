package exercicios04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        // Utilizamos a estrutura de dados Fila para armazenar os atendimentos
        Queue<String> filaAtendimento = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar atendimento");
            System.out.println("2 - Remover atendimento (em ordem de chegada)");
            System.out.println("3 - Finalizar atendimento");
            System.out.println("4 - Encerrar o sistema");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    cadastrarAtendimento(scanner, filaAtendimento);
                    break;
                case 2:
                    removerAtendimento(filaAtendimento);
                    break;
                case 3:
                    finalizarAtendimento(filaAtendimento);
                    break;
                case 4:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }

    private static void cadastrarAtendimento(Scanner scanner, Queue<String> filaAtendimento) {
        System.out.println("Informe o nome da pessoa para atendimento:");
        String nome = scanner.nextLine();
        filaAtendimento.add(nome);
        System.out.println("Atendimento cadastrado com sucesso.");
    }

    private static void removerAtendimento(Queue<String> filaAtendimento) {
        if (!filaAtendimento.isEmpty()) {
            String atendimentoRemovido = filaAtendimento.poll();
            System.out.println("Atendimento removido: " + atendimentoRemovido);
        } else {
            System.out.println("Fila de atendimento vazia. Nenhum atendimento para remover.");
        }
    }

    private static void finalizarAtendimento(Queue<String> filaAtendimento) {
        System.out.println("Finalizando atendimentos restantes:");

        while (!filaAtendimento.isEmpty()) {
            String atendimento = filaAtendimento.poll();
            System.out.println("Atendimento: " + atendimento);
        }

        System.out.println("Todos os atendimentos foram finalizados.");
    }
}
