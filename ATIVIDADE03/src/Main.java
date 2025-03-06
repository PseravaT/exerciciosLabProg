class No {
    int valor;
    No prox;

    No(int valor) {
        this.valor = valor;
        this.prox = null;
    }
}

class PilhaDinamica {
    private No topo;

    PilhaDinamica() {
        this.topo = null;
    }

    void push(int valor) {
        No novoNo = new No(valor);
        novoNo.prox = topo;
        topo = novoNo;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia! Nada para remover.");
            return -1;
        }
        int valorRemovido = topo.valor;
        topo = topo.prox;
        return valorRemovido;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Pilha vazia! Nada no topo.");
            return -1;
        }
        return topo.valor;
    }

    boolean isEmpty() {
        return topo == null;
    }

    void exibir() {
        if (isEmpty()) {
            System.out.println("Pilha vazia.");
            return;
        }
        System.out.println("Elementos da pilha:");
        No atual = topo;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.prox;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Pilha Sequencial ====");
        PilhaDinamica pilhaArray = new PilhaDinamica();
        pilhaArray.push(10);
        pilhaArray.push(20);
        pilhaArray.push(30);
        pilhaArray.exibir();
        System.out.println("Topo da pilha: " + pilhaArray.peek());
        System.out.println("Removendo: " + pilhaArray.pop());
        pilhaArray.exibir();

        System.out.println("\n==== Pilha Dinâmica ====");
        PilhaDinamica pilhaLista = new PilhaDinamica();
        pilhaLista.push(100);
        pilhaLista.push(200);
        pilhaLista.push(300);
        pilhaLista.exibir();
        System.out.println("Topo da pilha: " + pilhaLista.peek());
        System.out.println("Removendo: " + pilhaLista.pop());
        pilhaLista.exibir();
    }
}
