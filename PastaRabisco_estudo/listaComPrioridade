class Pessoa {
    String nome;
    int idade;
    Pessoa apontando;

    Pessoa(String novoNome, int novaIdade) {
        nome = novoNome;
        idade = novaIdade;
        apontando = null;
    }
}

class ListaPrioritaria {
    Pessoa inicio;
    Pessoa fim;

    ListaPrioritaria() {
        inicio = fim = null;
    }

    // Função para inserir
    void inserir(String nome, int idade) {
        Pessoa novaPessoa = new Pessoa(nome, idade);

        if (inicio == null) { // Se a lista estiver vazia, adiciona no início
            inicio = fim = novaPessoa;
        } else if (inicio.idade >= idade) { // Se for para adicionar no início
            novaPessoa.apontando = inicio;
            inicio = novaPessoa;
        } else { // Percorre a lista para adicionar no meio ou no final
            Pessoa atual = inicio;

            while (atual.apontando != null && atual.apontando.idade < idade) { // Corrigi para ordem correta
                atual = atual.apontando;
            }

            novaPessoa.apontando = atual.apontando; // Adiciona no meio
            atual.apontando = novaPessoa;

            if (novaPessoa.apontando == null) { // Se for o último, atualiza o fim
                fim = novaPessoa;
            }
        }
    }

    // Função de remoção
    void remover(String nome, int idade) {
        if (inicio == null) {
            System.out.println("Lista se encontra vazia");
            return;
        }

        // Caso o início já atenda, remove a primeira
        if (inicio.nome.equals(nome) && inicio.idade == idade) {
            inicio = inicio.apontando;
            if (inicio == null) fim = null; // Se o início agora for vazio, o fim também será vazio
            return;
        }

        // Corre a lista para remover o item necessário
        Pessoa atual = inicio;
        while (atual.apontando != null && !(atual.apontando.nome.equals(nome) && atual.apontando.idade == idade)) {
            atual = atual.apontando;
        }

        // Se não encontrar, avisa que a pessoa não foi encontrada
        if (atual.apontando == null) {
            System.out.println("Pessoa não encontrada");
            return;
        }

        // Faz com que o atual "pule" a pessoa a ser removida
        atual.apontando = atual.apontando.apontando;
        if (atual.apontando == null) fim = atual; // Se foi o último, atualiza o fim
    }

    // Função para exibir a lista
    void exibir() {
        Pessoa olheiro = inicio;
        System.out.println("\nLista:");
        while (olheiro != null) {
            System.out.println(olheiro.nome + " tem " + olheiro.idade + " anos");
            olheiro = olheiro.apontando;
        }
    }
}

public class lista {
    public static void main(String[] args) {
        ListaPrioritaria lista = new ListaPrioritaria();

        // Inserindo elementos na lista
        System.out.println("Inserindo elementos...");
        lista.inserir("Ana", 30);
        lista.inserir("Carlos", 25);
        lista.inserir("Bruno", 28);
        lista.inserir("Diana", 35);
        lista.inserir("Ester", 22);

        // Exibindo a lista após inserções
        System.out.println("\nLista após inserções:");
        lista.exibir();

        // Removendo um elemento do meio
        System.out.println("\nRemovendo Bruno (28 anos)...");
        lista.remover("Bruno", 28);
        lista.exibir();

        // Removendo o primeiro elemento
        System.out.println("\nRemovendo Diana (35 anos)...");
        lista.remover("Diana", 35);
        lista.exibir();

        // Removendo o último elemento
        System.out.println("\nRemovendo Ester (22 anos)...");
        lista.remover("Ester", 22);
        lista.exibir();

        // Tentando remover um elemento que não existe
        System.out.println("\nTentando remover João (40 anos)...");
        lista.remover("João", 40);
        lista.exibir();
    }
}
