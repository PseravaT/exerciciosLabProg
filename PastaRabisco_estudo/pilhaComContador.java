class Pessoa {
    String nome;
    Pessoa apontando;

    Pessoa(String novoNome) {
        nome = novoNome;
        apontando = null;
    }
}

class Pilha {
    Pessoa topo;
    int tamanho;

    Pilha() {
        topo = null; // Inicializa a pilha vazia
        tamanho = 0; // Inicializa o tamanho da pilha
    }

    // Função para empilhar um novo item
    void empilhar(String nome) {
        Pessoa novaPessoa = new Pessoa(nome);
        novaPessoa.apontando = topo; // Nova pessoa aponta para o topo atual
        topo = novaPessoa; // Atualiza o topo para a nova pessoa
        tamanho++; // Aumenta o tamanho da pilha
    }

    // Função para desempilhar o item do topo
    String desempilhar() {
        if (topo == null) {
            System.out.println("Fila ta Vazia já");
        }
        String nomeRemovido = topo.nome; // Armazena o nome do topo
        topo = topo.apontando; // Atualiza o topo para o próximo item
        tamanho--; // Diminui o tamanho da pilha
        return nomeRemovido; // Retorna o nome removido
    }

    // Função para buscar um item na pilha e retornar sua posição
    int buscar(String nome) {
        Pessoa atual = topo;
        int posicao = 1;

        while (atual != null) {
            if (atual.nome.equals(nome)) { // Verifica se o nome corresponde
                return posicao; // Retorna a posição quando encontrado
            }
            atual = atual.apontando; // Avança para o próximo item
            posicao++; // Aumenta a posição
        }
        return -1; // Retorna -1 se o item não for encontrado
    }

    // Função para exibir os itens da pilha
    void exibir() {
        Pessoa atual = topo;

        while (atual != null) {
            System.out.println(atual.nome); // Exibe o nome do item
            atual = atual.apontando; // Avança para o próximo item
        }
    }
}

public class pilhaComContador {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        // Empilhando elementos
        pilha.empilhar("Ana");
        pilha.empilhar("Carlos");
        pilha.empilhar("Bruno");

        // Exibindo a pilha
        pilha.exibir();

        // Buscando elementos na pilha
        System.out.println("\nPosição de Carlos: " + pilha.buscar("Carlos"));
        System.out.println("Posição de Diana: " + pilha.buscar("Diana"));

        // Desempilhando elementos
        System.out.println("\nDesempilhado: " + pilha.desempilhar());
        pilha.exibir();

        // Buscando após desempilhar
        System.out.println("\nPosição de Carlos após desempilhar: " + pilha.buscar("Carlos"));
    }
}
