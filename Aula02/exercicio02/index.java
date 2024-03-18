import java.util.Scanner;
import java.util.Vector;

public class index {
    private static Scanner scanner = new Scanner(System.in);
    private static Vector<String> registros = new Vector<>();

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Selecionar todos os registros");
            System.out.println("3 - Pesquisar por termo");
            System.out.println("4 - Alterar dados");
            System.out.println("5 - Remover registro");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    selecionarTodos();
                    break;
                case 3:
                    pesquisarPorTermo();
                    break;
                case 4:
                    alterarDados();
                    break;
                case 5:
                    removerRegistro();
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

    private static void cadastrar() {
        System.out.println("Digite o novo registro:");
        String novoRegistro = scanner.nextLine();
        if (!registros.contains(novoRegistro)) {
            registros.add(novoRegistro);
            System.out.println("Registro cadastrado com sucesso.");
        } else {
            System.out.println("Este registro já existe.");
        }
    }

    private static void selecionarTodos() {
        if (registros.isEmpty()) {
            System.out.println("Não há registros cadastrados.");
        } else {
            System.out.println("Registros cadastrados:");
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }

    private static void pesquisarPorTermo() {
        System.out.println("Digite o termo de pesquisa:");
        String termo = scanner.nextLine();
        boolean encontrado = false;
        for (String registro : registros) {
            if (registro.contains(termo)) {
                System.out.println(registro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum registro encontrado com o termo '" + termo + "'.");
        }
    }

    private static void alterarDados() {
        System.out.println("Digite o registro que deseja alterar:");
        String registroAntigo = scanner.nextLine();
        System.out.println("Digite o novo registro:");
        String novoRegistro = scanner.nextLine();
        if (registros.contains(registroAntigo)) {
            int indice = registros.indexOf(registroAntigo);
            registros.set(indice, novoRegistro);
            System.out.println("Registro alterado com sucesso.");
        } else {
            System.out.println("Registro não encontrado.");
        }
    }

    private static void removerRegistro() {
        System.out.println("Digite o registro que deseja remover:");
        String registro = scanner.nextLine();
        if (registros.contains(registro)) {
            registros.remove(registro);
            System.out.println("Registro removido com sucesso.");
        } else {
            System.out.println("Registro não encontrado.");
        }
    }
}