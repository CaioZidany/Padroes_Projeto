public class Tarefa implements ITarefa {
    private final String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    @Override
    public void marcarConcluida() {
        if (!concluida) {
            this.concluida = true;
            System.out.println("Tarefa marcada!");
        } else {
            this.concluida = false;
            System.out.println("Tarefa desmarcada!");
        }
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public String toString() {
        return "[" + (concluida ? "X" : " ") + "] " + descricao;
    }
}