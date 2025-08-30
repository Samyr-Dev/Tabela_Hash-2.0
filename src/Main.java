import Hash_model.HashTable;
import Hash_model.Pessoa;


public class Main {
    public static void main(String[] args) {
        HashTable tabela = new HashTable(10);

        tabela.inserir(new Pessoa("12345678900", "João", 25));
        tabela.inserir(new Pessoa("98765432100", "Maria", 30));
        tabela.inserir(new Pessoa("11122233344", "Ana", 22));

        tabela.imprimirTabela();

        System.out.println("\nBusca pelo CPF 98765432100:");
        Pessoa encontrada = tabela.buscar("98765432100");
        System.out.println(encontrada != null ? encontrada : "Não encontrada");

        System.out.println("\nRemovendo CPF 12345678900:");
        tabela.remover("12345678900");
        tabela.imprimirTabela();

    }
}