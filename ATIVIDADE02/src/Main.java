class No {
    int valor;
    int prioridade;
    No prox;

    No(int novaPrioridade, int novoValor) {
        prioridade = novaPrioridade;
        valor = novoValor;
        prox = null;
    }
}

class FilaPrioritaria {
    No inicio;
    int tamanho;

    FilaPrioritaria() {
        inicio = null;
        tamanho = 0;
    }

    void inserir(int novoValor, int novaPrioridade) {
        No novoNo = new No(novaPrioridade, novoValor);

        if (inicio == null || novoNo.prioridade > inicio.prioridade) {

            novoNo.prox = inicio;
            inicio = novoNo;
        } else {

            No atual = inicio;
            while (atual.prox != null && atual.prox.prioridade >= novoNo.prioridade) {
                atual = atual.prox;
            }
            novoNo.prox = atual.prox;
            atual.prox = novoNo;
        }

        tamanho++;
    }

    void remover() {
        if (inicio == null) {
            System.out.println("Fila vazia, nada para remover.");
            return;
        }

        System.out.println("Removendo: " + inicio.valor + " (Prioridade " + inicio.prioridade + ")");
        inicio = inicio.prox;
        tamanho--;
    }

    int contar() {
        System.out.println("Quantidade de elementos na fila: " + tamanho);
        return tamanho;
    }

    void exibir() {
        if (inicio == null) {
            System.out.println("Fila vazia.");
            return;
        }

        System.out.println("Elementos na fila (ordem de prioridade):");
        No atual = inicio;
        while (atual != null) {
            System.out.println("Valor: " + atual.valor + " | Prioridade: " + atual.prioridade);
            atual = atual.prox;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FilaPrioritaria fila = new FilaPrioritaria();

        fila.inserir(5, 2);
        fila.inserir(10, 5);
        fila.inserir(15, 1);
        fila.inserir(20, 10);
        fila.inserir(25, 5);

        System.out.println("\nFila após inserções:");
        fila.exibir();

        System.out.println("\nRemovendo o elemento de maior prioridade:");
        fila.remover();

        System.out.println("\nFila depois da remoção:");
        fila.exibir();

        System.out.println("\nContagem de elementos na fila:");
        fila.contar();
    }
}
