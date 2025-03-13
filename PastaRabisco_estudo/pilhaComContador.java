class Pessoa{
    String nome;
    Pessoa apontando;

    Pessoa (String novoNome){
        nome = novoNome;
        apontando = null;
    }
}


class Pilha{
    Pessoa topo;
    int tamanho;

    Pilha(){
        topo = null;
        tamanho = 0;
    }

    void empilhar (String nome){
        Pessoa novaPessoa = new Pessoa(nome);
        novaPessoa.apontando = topo;
        topo = novaPessoa;
        tamanho ++;
    }

    void desempilhar() {
        if (topo == null) {
            System.out.println("Fila está vazia.");
            return;
        }
        topo = topo.apontando;
        tamanho--;
    }


    int buscar(String nome){
        Pessoa atual = topo;
        int posicao = 1;

        while( atual != null ){
            if (!atual.nome.equals(nome)){
                return posicao;
            }
            atual = atual.apontando;
            posicao ++;
        }
        return -1;
    }
    void exibir(){
        Pessoa atual = topo;

        while (topo != null){
            System.out.println(atual);
            atual = atual.apontando;
        }
    }
}

public class pilhaComContador {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.empilhar("Alice");
        pilha.empilhar("Bob");
        pilha.empilhar("Charlie");

        System.out.println("Elementos na pilha:");
        pilha.exibir();

        System.out.println("\nPosição de Bob: " + pilha.buscar("Bob"));

        System.out.println("\nDesempilhando...");
        pilha.desempilhar();

        System.out.println("\nElementos na pilha após desempilhar:");
        pilha.exibir();
    }
}
