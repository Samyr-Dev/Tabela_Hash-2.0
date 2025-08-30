package Hash_model;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Pessoa>[] tabela;
    private int tamanho;
    private int colissoes;


    public HashTable(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
        colissoes = 0;
    }

    private int hash(String cpf) {
        return Math.abs(cpf.hashCode()) % tamanho;
    }

    public void inserir(Pessoa pessoa) {
        int pos = hash(pessoa.getCpf());
        if (!tabela[pos].isEmpty()) {
            colissoes++;
        }
        tabela[pos].add(pessoa);
    }

    public Pessoa buscar(String cpf) {
        int pos = hash(cpf);
        for (Pessoa p : tabela[pos]) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public boolean remover(String cpf) {
        int pos = hash(cpf);
        return tabela[pos].removeIf(p -> p.getCpf().equals(cpf));
    }

    public void imprimirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Posição " + i + ": ");
            if (tabela[i].isEmpty()) {
                System.out.println("vazio");
            } else {
                for (Pessoa p : tabela[i]) {
                    System.out.print(p + " | ");
                }
                System.out.println();
            }
        }
        System.out.println("Número de colisões: " + colissoes);
    }
}

