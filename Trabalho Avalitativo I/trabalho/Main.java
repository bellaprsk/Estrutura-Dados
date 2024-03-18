package trabalho;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Concluir próxima tarefa");
            System.out.println("3. Visualizar próxima tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");

            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite a descrição da tarefa:");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(descricao);
                    System.out.println("Tarefa adicionada.");
                    break;
                case "2":
                    gerenciador.concluirProximaTarefa();
                    System.out.println("Próxima tarefa concluída.");
                    break;
                case "3":
                    Tarefa proximaTarefa = gerenciador.obterProximaTarefa();
                    if (proximaTarefa != null) {
                        System.out.println("Próxima tarefa: " + proximaTarefa.getDescricao());
                    } else {
                        System.out.println("Não há tarefas pendentes.");
                    }
                    break;
                case "4":
                    System.out.println("Digite o índice da tarefa a ser removida:");
                    int indice = scanner.nextInt();
                    gerenciador.removerTarefa(indice);
                    break;
                case "5":
                    System.out.println("Encerrando programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("5"));

        scanner.close();
    }
}





