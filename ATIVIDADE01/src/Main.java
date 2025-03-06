class Fila {
    String[] nomes;
    int fim, tamanhoFila;

    Fila() {
        nomes = new String[5];
        fim = -1;
        tamanhoFila = 0;
    }

    boolean vazia() {
        return tamanhoFila == 0;
    }

    boolean cheia() {
        return tamanhoFila == nomes.length;
    }

    void enfileirar(String nome) {
        if (cheia()) {
            System.out.println("Fila cheia, dobrando o tamanho...");
            dobrarTamanho();
        }

        fim++;
        nomes[fim] = nome;
        tamanhoFila++;
        System.out.println("Enfileirou: " + nome);
    }

    void desenfileirar() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return;
        } else {
            for (int i = 0; i < fim; i++) {
                nomes[i] = nomes[i + 1];
            }
            nomes[fim] = null;
            fim--;
            tamanhoFila--;
            System.out.println("Desenfileirado.");
        }
    }

    void imprimir() {
        System.out.println("Você possui uma lista de " + tamanhoFila + " itens:");
        for (int i = 0; i < tamanhoFila; i++) {
            System.out.println(nomes[i]);
        }
    }

    void dobrarTamanho() {
        String[] novoTamanho = new String[nomes.length * 2];
        for (int i = 0; i < nomes.length; i++) {
            novoTamanho[i] = nomes[i];
        }
        nomes = novoTamanho;
        System.out.println("Novo tamanho da fila: " + nomes.length);
    }
}


class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.enfileirar("João");
        fila.enfileirar("Maria");
        fila.enfileirar("Pedro");
        fila.enfileirar("Carlos");
        fila.enfileirar("Paulo");

        fila.imprimir();

        fila.enfileirar("Ana");

        fila.imprimir();

        fila.desenfileirar();
        fila.imprimir();
    }
}
