import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    public void procurarContato(String nome) {
        boolean encontrado = false;
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println(contato);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Listar contatos");
            System.out.println("3. Procurar contato");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            if (opcao == 1) {
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o telefone: ");
                String telefone = scanner.nextLine();
                System.out.print("Digite o email: ");
                String email = scanner.nextLine();
                Contato contato = new Contato(nome, telefone, email);
                agenda.adicionarContato(contato);
                System.out.println("Contato adicionado com sucesso.");
            } else if (opcao == 2) {
                agenda.listarContatos();
            } else if (opcao == 3) {
                System.out.print("Digite o nome do contato: ");
                String nome = scanner.nextLine();
                agenda.procurarContato(nome);
            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
