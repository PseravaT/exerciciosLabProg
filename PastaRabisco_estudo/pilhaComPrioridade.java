class Pessoa {
    String nome;
    int peso;
    Pessoa apontando;

    Pessoa(String novoNome, int novoPeso) {
        nome = novoNome;
        peso = novoPeso;
        apontando = null;
    }
}

class Pilha {
    Pessoa topo;
    int tamanho;

    Pilha() {
        topo = null;
        tamanho = 0;
    }

    void empilhar(String nome, int peso) {
        Pessoa novaPessoa = new Pessoa(nome, peso);
        novaPessoa.apontando = topo;
        topo = novaPessoa;
        tamanho++;
    }

    void desempilhar() {
        if (topo == null) {
            System.out.println("Pilha está vazia.");
            return;
        }
        topo = topo.apontando;
        tamanho--;
    }

    int buscarPorNome(String nome) {
        Pessoa atual = topo;
        int posicao = 1;

        while (atual != null) {
            if (atual.nome.equals(nome)) {
                return posicao;
            }
            atual = atual.apontando;
            posicao++;
        }

        System.out.println("Pessoa com nome '" + nome + "' não encontrada.");
        return -1;
    }

    int buscarPorPeso(int peso) {
        Pessoa atual = topo;
        int posicao = 1;

        while (atual != null) {
            if (atual.peso == peso) {
                return posicao;
            }
            atual = atual.apontando;
            posicao++;
        }

        System.out.println("Pessoa com peso '" + peso + "kg' não encontrada.");
        return -1;
    }

    int qntItens() {
        return tamanho;
    }

    void exibir() {
        Pessoa atual = topo;

        if (atual == null) {
            System.out.println("Pilha está vazia.");
            return;
        }

        System.out.println("\nPilha atual:");
        while (atual != null) {
            System.out.println(atual);
            atual = atual.apontando;
        }
        System.out.println("Total de itens: " + tamanho);
    }
}

public class pilhaComPrioridade {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.empilhar("Alice", 60);
        pilha.empilhar("Bob", 75);
        pilha.empilhar("Carlos", 80);

        pilha.exibir();

        System.out.println("Posição de Bob: " + pilha.buscarPorNome("Bob"));
        System.out.println("Posição de alguém com 75kg: " + pilha.buscarPorPeso(75));

        pilha.desempilhar();
        pilha.exibir();

        pilha.buscarPorNome("Daniel");
        pilha.buscarPorPeso(50);
    }
}
