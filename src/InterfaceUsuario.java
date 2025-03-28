import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    private final GerenciadorTarefas gerenciador;
    private final Scanner scanner;

    public InterfaceUsuario(GerenciadorTarefas gerenciador) {
        this.gerenciador = gerenciador;
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        while (true) {
            System.out.println("\nGerenciador de Tarefas");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Listar tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa buffer

                switch (opcao) {
                    case 1:
                        adicionarTarefa();
                        break;
                    case 2:
                        removerTarefa();
                        break;
                    case 3:
                        concluirTarefa();
                        break;
                    case 4:
                        listarTarefas();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.nextLine();
            }
        }
    }

    private void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        try {
            gerenciador.adicionarTarefa(descricao);
            System.out.println("Tarefa adicionada!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerTarefa() {
        listarTarefas();
        System.out.print("Digite o número da tarefa a ser removida: ");
        try {
            int indice = scanner.nextInt() - 1;
            gerenciador.removerTarefa(indice);
            System.out.println("Tarefa removida!");
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Número inválido!");
            scanner.nextLine();
        }
    }

    private void concluirTarefa() {
        listarTarefas();
        System.out.print("Digite o número da tarefa a ser concluída: ");
        try {
            int indice = scanner.nextInt() - 1;
            gerenciador.concluirTarefa(indice);
            System.out.println("Tarefa marcada como concluída!");
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Número inválido!");
            scanner.nextLine();
        }
    }

    private void listarTarefas() {
        List<ITarefa> tarefas = gerenciador.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("\nLista de Tarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i));
        }
    }
}
