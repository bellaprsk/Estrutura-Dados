import java.util.Scanner;

public class index {
    private static final int TAMANHO_ARRAY = 10;

    private static String[] nomes = new String[TAMANHO_ARRAY];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos os nomes");
            System.out.println("3 - Alterar");
            System.out.println("4 - Remover");
            System.out.println("5 - Finalizar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNome(scanner);
                    break;
                case 2:
                    listarNomes();
                    break;
                case 3:
                    alterarNome(scanner);
                    break;
                case 4:
                    removerNome(scanner);
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarNome(Scanner scanner) {
        System.out.println("Digite o nome a ser cadastrado:");
        String nome = scanner.nextLine();

        for (int i = 0; i < TAMANHO_ARRAY; i++) {
            if (nomes[i] == null) {
                nomes[i] = nome;
                System.out.println("Nome cadastrado com sucesso.");
                return;
            }
        }

        System.out.println("O array está cheio. Não é possível cadastrar mais nomes.");
    }

    private static void listarNomes() {
        System.out.println("\nLista de Nomes:");
        for (int i = 0; i < TAMANHO_ARRAY; i++) {
            if (nomes[i] != null) {
                System.out.println((i + 1) + ". " + nomes[i]);
            }
        }
    }

    private static void alterarNome(Scanner scanner) {
        System.out.println("Digite o índice do nome a ser alterado:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        if (indice > 0 && indice <= TAMANHO_ARRAY && nomes[indice - 1] != null) {
            System.out.println("Digite o novo nome:");
            String novoNome = scanner.nextLine();
            nomes[indice - 1] = novoNome;
            System.out.println("Nome alterado com sucesso.");
        } else {
            System.out.println("Índice inválido ou nome não encontrado.");
        }
    }

    private static void removerNome(Scanner scanner) {
        System.out.println("Digite o índice do nome a ser removido:");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice > 0 && indice <= TAMANHO_ARRAY && nomes[indice - 1] != null) {
            nomes[indice - 1] = null;
            System.out.println("Nome removido com sucesso.");
        } else {
            System.out.println("Índice inválido ou nome não encontrado.");
        }
    }
}
