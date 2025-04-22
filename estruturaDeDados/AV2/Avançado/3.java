import java.util.*;


class No {
    String valor;
    No prox;

    No(String valor) {
        this.valor = valor;
        this.prox = null;
    }
}


class FilaEncadeada {
    private No inicio;
    private No fim;

    public FilaEncadeada() {
        inicio = null;
        fim = null;
    }

    public void enfileirar(String valor) {
        No novo = new No(valor);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.prox = novo;
            fim = novo;
        }
    }

    public String desenfileirar() {
        if (inicio == null) return null;

        String valor = inicio.valor;
        inicio = inicio.prox;
        if (inicio == null) fim = null;
        return valor;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}


class Grafo {
    private Map<String, List<String>> grafo;

    public Grafo() {
        grafo = new HashMap<>();
    }

    public void adicionarVertice(String v) {
        if (!grafo.containsKey(v)) {
            grafo.put(v, new ArrayList<>());
        }
    }

    public void adicionarAresta(String a, String b) {
        if (grafo.containsKey(a) && grafo.containsKey(b)) {
            if (!grafo.get(a).contains(b)) grafo.get(a).add(b);
            if (!grafo.get(b).contains(a)) grafo.get(b).add(a);
        }
    }

    public void mostrarGrafo() {
        System.out.println("Lista de Adjacência:");
        for (String v : grafo.keySet()) {
            System.out.println(v + " → " + grafo.get(v));
        }
    }

    public void bfsComFilaEncadeada(String inicio) {
        if (!grafo.containsKey(inicio)) {
            System.out.println("Vértice '" + inicio + "' não existe no grafo.");
            return;
        }

        Set<String> visitados = new HashSet<>();
        FilaEncadeada fila = new FilaEncadeada();

        fila.enfileirar(inicio);
        visitados.add(inicio);

        System.out.println("Iniciando BFS com fila encadeada a partir de '" + inicio + "':");

        while (!fila.estaVazia()) {
            String atual = fila.desenfileirar();
            System.out.println("- Visitando: " + atual);

            for (String vizinho : grafo.get(atual)) {
                if (!visitados.contains(vizinho)) {
                    fila.enfileirar(vizinho);
                    visitados.add(vizinho);
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        g.adicionarVertice("A");
        g.adicionarVertice("B");
        g.adicionarVertice("C");
        g.adicionarVertice("D");
        g.adicionarVertice("E");

        g.adicionarAresta("A", "B");
        g.adicionarAresta("A", "C");
        g.adicionarAresta("B", "D");
        g.adicionarAresta("C", "E");

        g.mostrarGrafo();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o vértice inicial da BFS com fila encadeada: ");
        String inicio = scanner.nextLine();

        g.bfsComFilaEncadeada(inicio);
    }
}
