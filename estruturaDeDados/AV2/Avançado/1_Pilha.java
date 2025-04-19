import java.util.*;

class No{
    String valor;
    No prox;

    No (String valor){
        this.valor = valor;
        this.prox = null;
    }
}

class Pilha {
    private No topo;

    Pilha() {
        topo = null;
    }

    void push(String valor) {
        No novoNo = new No(valor);
        novoNo.prox = topo;
        topo = novoNo;
    }

    String pop() {
        if (isEmpty()) return null;
        String valor = topo.valor;
        topo = topo.prox;
        return valor;
    }

    String peek() {
        return isEmpty() ? null : topo.valor;
    }

    boolean isEmpty() {
        return topo == null;
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
            if (!grafo.get(b).contains(a)) grafo.get(b).add(a); // não-direcionado
        }
    }

    public boolean temCicloComPilha() {
        Set<String> visitados = new HashSet<>();

        for (String inicio : grafo.keySet()) {
            if (!visitados.contains(inicio)) {
                if (dfsComPilha(inicio, visitados)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsComPilha(String inicio, Set<String> visitados) {
        Pilha pilha = new Pilha();
        Map<String, String> pai = new HashMap<>();

        pilha.push(inicio);
        pai.put(inicio, null);

        while (!pilha.isEmpty()) {
            String atual = pilha.pop();

            if (!visitados.contains(atual)) {
                visitados.add(atual);
            }

            for (String vizinho : grafo.get(atual)) {
                if (!visitados.contains(vizinho)) {
                    pilha.push(vizinho);
                    pai.put(vizinho, atual);
                } else if (!vizinho.equals(pai.get(atual))) {
                    return true; // ciclo detectado
                }
            }
        }

        return false;
    }

    public void mostrarGrafo() {
        for (String v : grafo.keySet()) {
            System.out.println(v + " → " + grafo.get(v));
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

        g.adicionarAresta("A", "B");
        g.adicionarAresta("B", "C");
        g.adicionarAresta("C", "A"); // ← ciclo aqui
        g.adicionarAresta("C", "D");

        g.mostrarGrafo();

        if (g.temCicloComPilha()) {
            System.out.println("Ciclo detectado no grafo.");
        } else {
            System.out.println("rafo não contém ciclos.");
        }
    }
}
