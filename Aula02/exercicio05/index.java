package exercicio05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class index {
    private static Map<Integer, Aluno> alunos = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Selecionar todos os alunos");
            System.out.println("3 - Alterar dados de um aluno");
            System.out.println("4 - Remover aluno");
            System.out.println("5 - Estatísticas");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    selecionarTodosAlunos();
                    break;
                case 3:
                    alterarDadosAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    exibirEstatisticas();
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

    private static void cadastrarAluno() {
        System.out.println("Digite o ID do aluno:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (alunos.containsKey(id)) {
            System.out.println("Já existe um aluno cadastrado com este ID.");
            return;
        }

        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite a nota do aluno:");
        double nota = scanner.nextDouble();

        Aluno aluno = new Aluno(nome, nota);
        alunos.put(id, aluno);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private static void selecionarTodosAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
        } else {
            System.out.println("Alunos cadastrados:");
            for (Map.Entry<Integer, Aluno> entry : alunos.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Nome: " + entry.getValue().getNome() + ", Nota: "
                        + entry.getValue().getNota());
            }
        }
    }

    private static void alterarDadosAluno() {
        System.out.println("Digite o ID do aluno que deseja alterar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (!alunos.containsKey(id)) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do aluno:");
        String novoNome = scanner.nextLine();
        System.out.println("Digite a nova nota do aluno:");
        double novaNota = scanner.nextDouble();

        Aluno aluno = alunos.get(id);
        aluno.setNome(novoNome);
        aluno.setNota(novaNota);
        System.out.println("Dados do aluno alterados com sucesso.");
    }

    private static void removerAluno() {
        System.out.println("Digite o ID do aluno que deseja remover:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        if (!alunos.containsKey(id)) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        alunos.remove(id);
        System.out.println("Aluno removido com sucesso.");
    }

    private static void exibirEstatisticas() {
        int totalAlunos = alunos.size();
        int aprovados = 0;
        int reprovados = 0;

        for (Aluno aluno : alunos.values()) {
            if (aluno.getNota() >= 6.0) {
                aprovados++;
            } else {
                reprovados++;
            }
        }

        System.out.println("Estatísticas:");
        System.out.println("Total de alunos registrados: " + totalAlunos);
        System.out.println("Total de alunos aprovados: " + aprovados);
        System.out.println("Total de alunos reprovados: " + reprovados);
    }
}

class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
