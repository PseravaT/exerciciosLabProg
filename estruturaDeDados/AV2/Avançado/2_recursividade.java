import java.util.*;

class Grafo {
    private Map<String, List<String>> grafo;

    public Grafo() {
        grafo = new HashMap<>();
    }


    public void addVertice(String v) {
        if (!grafo.containsKey(v)) {
            grafo.put(v, new ArrayList<>());
        }
    }


    public void addAresta(String a, String b) {
        if (grafo.containsKey(a) && grafo.containsKey(b)) {
            if (!grafo.get(a).contains(b)){
                grafo.get(a).add(b);
            }
            if (!grafo.get(b).contains(a)){
                grafo.get(b).add(a);
            }
        }
    }


    public void dfsRecursiva(String inicio) {
        if (!grafo.containsKey(inicio)) {
            System.out.println("Vértice '" + inicio + "' não existe no grafo.");
            return;
        }

        Set<String> visitados = new HashSet<>();
        System.out.println("Iniciando DFS a partir de " + inicio + ":");
        dfsAux(inicio, visitados);
    }
    private void dfsAux(String atual, Set<String> visitados) {
        System.out.println("- Visitando: " + atual);
        visitados.add(atual);

        for (String vizinho : grafo.get(atual)) {
            if (!visitados.contains(vizinho)) {
                dfsAux(vizinho, visitados);
            }
        }
    }

    public void mostrarGrafo() {
        System.out.println(" Lista de Adjacência:");
        for (String v : grafo.keySet()) {
            System.out.println(v + " → " + grafo.get(v));
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        g.addVertice("A");
        g.addVertice("B");
        g.addVertice("C");
        g.addVertice("D");
        g.addVertice("E");

        g.addAresta("A", "B");
        g.addAresta("A", "C");
        g.addAresta("B", "D");
        g.addAresta("C", "E");

        g.mostrarGrafo();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o vértice inicial para DFS recursiva: ");
        String inicio = scanner.nextLine();

        g.dfsRecursiva(inicio);
    }
}
