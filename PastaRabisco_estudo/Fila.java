class Pessoa {
    String nome;
    Pessoa apontando;

    Pessoa(String novoNome) {
        this.nome = novoNome;
        this.apontando = null;
    }
}

class Fila {
    Pessoa inicio;
    Pessoa fim;

    Fila() {
        this.inicio = null;
        this.fim = null;
    }

    void inserir(String nome) {
        Pessoa novaPessoa = new Pessoa(nome);
        if (fim == null) {
            // Se a fila está vazia, o novo elemento é início e fim
            inicio = fim = novaPessoa;
        } else {
            fim.apontando = novaPessoa;
            fim = novaPessoa;
        }
    }

    void remover() { // Corrigido de "desempilhar" para "remover" (FIFO)
        if (inicio == null) {
            System.out.println("Fila está vazia.");
            return;
        }

        inicio = inicio.apontando;
        if (inicio == null) { // Se a fila ficou vazia após remoção
            fim = null;
        }
    }

    void imprimir() {
        if (inicio == null) {
            System.out.println("Fila está vazia.");
            return;
        }

        Pessoa atual = inicio;
        while (atual != null) {
            System.out.println(atual.nome);
            atual = atual.apontando;
        }
        System.out.println("-----");
    }
}

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();

        // Teste de inserção
        fila.inserir("Carlos");
        fila.inserir("Maria");
        fila.inserir("Pedro");
        fila.inserir("Fernanda");

        System.out.println("Fila inicial:");
        fila.imprimir();

        fila.remover();
        System.out.println("Fila após remover um elemento:");
        fila.imprimir();
    }
}
