import Hash_model.HashTable;
import Hash_model.Pessoa;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashTable tabela = new HashTable(10);
        int opcao;


        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserir pessoa");
            System.out.println("2 - Buscar pessoa");
            System.out.println("3 - Remover pessoa");
            System.out.println("4 - Imprimir tabela");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha


            switch (opcao) {
                case 1:
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    tabela.inserir(new Pessoa(cpf, nome, idade));
                    break;
                case 2:
                    System.out.print("Informe o CPF para busca: ");
                    String buscaCpf = scanner.nextLine();
                    Pessoa p = tabela.buscar(buscaCpf);
                    System.out.println(p != null ? p : "Não encontrado.");
                    break;
                case 3:
                    System.out.print("Informe o CPF para remover: ");
                    String removeCpf = scanner.nextLine();
                    boolean removido = tabela.remover(removeCpf);
                    System.out.println(removido ? "Removido." : "Não encontrado.");
                    break;
                case 4:
                    tabela.imprimirTabela();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);


        scanner.close();
    }
}
