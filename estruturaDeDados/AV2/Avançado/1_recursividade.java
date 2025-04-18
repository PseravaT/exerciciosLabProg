import java.util.*;

class Grafo {
    Map<String, List<String>> grafo;

    Grafo () {
        grafo = new HashMap<>();
    }

    void addVertice (String v){
        if (!grafo.containsKey(v)){
            grafo.put(v,new ArrayList<>());
        }
    }


    void addAresta (String a, String b) {
        if (grafo.containsKey(a) && grafo.containsKey(b)) {
            if (!grafo.get(a).contains(b)) {
                grafo.get(a).add(b);
            }
            if (!grafo.get(a).contains(b)) {
                grafo.get(a).add(b);
            }
        }
    }

    void mostrarGrafo(){
        for (String v : grafo.keySet()){
            System.out.println(v + " → " + grafo.get(v));
        }
    }

    boolean temCiclo(){
        Set<String> visitados = new HashSet<>();

        for (String vertice : grafo.keySet()){
            if(!visitados.contains(vertice)){
                if (dfsDetectarCiclo(vertice, null, visitados)){
                    return true;
                }
            }

        }
        return false;
    }

    private boolean dfsDetectarCiclo(String atual, String pai, Set<String> visitados) {
        visitados.add(atual);

        for (String vizinho : grafo.get(atual)) {
            if (!visitados.contains(vizinho)) {
                if (dfsDetectarCiclo(vizinho, atual, visitados)) {
                    return true;
                }
            } else if (!vizinho.equals(pai)) {

                return true;
            }
        }

        return false;
    }
}



public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        g.addVertice("A");
        g.addVertice("B");
        g.addVertice("C");
        g.addVertice("D");

        g.addAresta("A", "B");
        g.addAresta("B", "C");
        g.addAresta("C", "A");
        g.addAresta("C", "D");

        g.mostrarGrafo();

        if (g.temCiclo()) {
            System.out.println("O grafo contém um ciclo.");
        } else {
            System.out.println("O grafo NÃO contém ciclos.");
        }
    }
}

