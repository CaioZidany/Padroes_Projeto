public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        InterfaceUsuario ui = new InterfaceUsuario(gerenciador);
        ui.executar();
    }
}