import java.util.*;

class Grafo{
    final Map<String, List<String>> grafo;

    public Grafo(){
        grafo = new HashMap<>();
    }

    void adicionarVertice(String vertice) {
        if(!grafo.containsKey(vertice)){
            grafo.put(vertice, new ArrayList<>());
        }
    }

    void addAresta (String primeiro, String segundo){
        if (grafo.containsKey(primeiro) && grafo.containsKey (segundo)){
            if (!grafo.get(primeiro).contains(segundo)) {
                grafo.get(primeiro).add(segundo);
            }
            if (!grafo.get(segundo).contains(primeiro)){
                grafo.get(segundo).add(primeiro);
            }
        }
    }

    void mostrarGrafo (){
        for (String vertice : grafo.keySet()){
            System.out.println(vertice + "--" + grafo.get(vertice));
        }
    }

    void vizinhos (String vertice){
        if (grafo.containsKey(vertice)) {
            System.out.println(vertice + "--" + grafo.get(vertice));
        }else {
            System.out.println("Vertice " + vertice +" não tem vizinhos");
        }
    }

    void temVertice(String esse, String comEsse) {
        if (!grafo.containsKey(esse)) {
            System.out.println("O vértice " + esse + " não existe.");
            return;
        }

        if (!grafo.containsKey(comEsse)) {
            System.out.println("O vértice " + comEsse + " não existe.");
            return;
        }

        if (grafo.get(esse).contains(comEsse)) {
            System.out.println("Existe ligação de " + esse + " para " + comEsse + ".");
        } else {
            System.out.println("Não existe ligação de " + esse + " para " + comEsse + ".");
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome de um vértice: ");
        String resposta = scanner.nextLine();

        g.vizinhos(resposta);

        System.out.print("\nDigite o primeiro vértices para verificar se tem ligação:");
        String esse = scanner.next();
        System.out.print("\nDigite o segundo vértices para verificar se tem ligação:");
        String comEsse = scanner.next();

        g.temVertice(esse, comEsse);

        scanner.close();
    }
}
