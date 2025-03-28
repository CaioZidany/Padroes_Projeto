import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private final List<ITarefa> tarefas;

    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        if (descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode estar vazia!");
        }
        tarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            throw new IndexOutOfBoundsException("Número inválido!");
        }
        tarefas.remove(indice);
    }

    public void concluirTarefa(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            throw new IndexOutOfBoundsException("Número inválido!");
        }
        tarefas.get(indice).marcarConcluida();
    }

    public List<ITarefa> listarTarefas() {
        return tarefas;
    }
}