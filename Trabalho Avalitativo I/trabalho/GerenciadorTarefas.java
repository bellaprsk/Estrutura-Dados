package trabalho;

import java.util.LinkedList;
import java.util.Queue;

public class GerenciadorTarefas {
    private Queue<Tarefa> filaDeTarefas;

    public GerenciadorTarefas() {
        filaDeTarefas = new LinkedList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        filaDeTarefas.add(novaTarefa);
    }

    public void concluirProximaTarefa() {
        if (!filaDeTarefas.isEmpty()) {
            filaDeTarefas.poll();
        } else {
            System.out.println("Não há tarefas para concluir.");
        }
    }

    public Tarefa obterProximaTarefa() {
        return filaDeTarefas.peek();
    }

    public void removerTarefa(int index) {
        if (index >= 0 && index < filaDeTarefas.size()) {
            Queue<Tarefa> novaFila = new LinkedList<>();
            int contador = 0;
            while (!filaDeTarefas.isEmpty()) {
                Tarefa tarefa = filaDeTarefas.poll();
                if (contador != index) {
                    novaFila.add(tarefa);
                }
                contador++;
            }
            filaDeTarefas = novaFila;
        } else {
            System.out.println("Índice inválido.");
        }
    }
}