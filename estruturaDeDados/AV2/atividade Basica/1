import java.util.*;

class Grafo{
    private Map<String, List<String>> grafo;

    public Grafo(){
        grafo = new HashMap<>();
    }

    void adicionarVertice(String vertice) {
        if(!grafo.containsKey(vertice)){
            grafo.put(vertice, new ArrayList<>());
        }
    }

    void addAresta(String origem, String destino) {
        if (grafo.containsKey(origem) && grafo.containsKey(destino)) {
            grafo.get(origem).add(destino);
        }
    }

    void mostrarGrafo (){
        for (String vertice : grafo.keySet()){
            System.out.println(vertice + "--" + grafo.get(vertice));
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


        g.addAresta("A", "B");
        g.addAresta("A", "C");
        g.addAresta("B", "D");
        g.addAresta("C", "D");
        g.addAresta("D", "E");
        g.addAresta("E", "A");


        g.mostrarGrafo();
    }
}
