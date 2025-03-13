class Pessoa {
    String nome;
    boolean urgencia;
    Pessoa apontando;

    Pessoa(String nome, boolean urgencia) {
        this.nome = nome;
        this.urgencia = urgencia;
        this.apontando = null;
    }
}

class Fila {
    Pessoa inicio;
    Pessoa fim;

    Fila() {
        inicio = fim = null;
    }

    void inserir(String nome, boolean urgencia) {
        Pessoa novaPessoa = new Pessoa(nome, urgencia);

        if (inicio == null) {
            inicio = fim = novaPessoa;
            return;
        }

        if (urgencia) {

            if (!inicio.urgencia) {
                novaPessoa.apontando = inicio;
                inicio = novaPessoa;
                return;
            }

            Pessoa atual = inicio;
            while (atual.apontando != null && atual.apontando.urgencia) {
                atual = atual.apontando;
            }
            novaPessoa.apontando = atual.apontando;
            atual.apontando = novaPessoa;


            if (novaPessoa.apontando == null) {
                fim = novaPessoa;
            }
        } else {

            fim.apontando = novaPessoa;
            fim = novaPessoa;
        }
    }

    void desempilhar() {
        if (inicio == null) {
            System.out.println("Fila está vazia.");
            return;
        }

        inicio = inicio.apontando;

        // Se a fila ficou vazia após a remoção, atualizar fim também
        if (inicio == null) {
            fim = null;
        }
    }

    void imprimir() {
        Pessoa atual = inicio;
        while (atual != null) {
            System.out.println(atual.nome + " - Urgente: " + (atual.urgencia ? "Sim" : "Não"));
            atual = atual.apontando;
        }
        System.out.println("-----");
    }
}

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();

        // Teste de inserção
        fila.inserir("Carlos", false);
        fila.inserir("Ana", false);
        fila.inserir("Pedro", true);
        fila.inserir("Fernanda", false);
        fila.inserir("Roberto", true);
        fila.inserir("Juliana", false);
        fila.inserir("Clara", true);


        System.out.println("Fila antes de remover:");
        fila.imprimir();

        fila.desempilhar();
        System.out.println("Fila após remover um elemento:");
        fila.imprimir();
    }
}
