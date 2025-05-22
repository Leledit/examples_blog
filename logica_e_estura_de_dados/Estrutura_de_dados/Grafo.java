import java.util.*;

public class Grafo {
    private Map<String, List<String>> adjacencias;

    public Grafo() {
        this.adjacencias = new HashMap<>();
    }

    public void adicionarVertice(String vertice) {
        adjacencias.putIfAbsent(vertice, new ArrayList<>());
    }

    public void adicionarAresta(String origem, String destino) {
        adjacencias.putIfAbsent(origem, new ArrayList<>());
        adjacencias.putIfAbsent(destino, new ArrayList<>());

        adjacencias.get(origem).add(destino);
        adjacencias.get(destino).add(origem);
    }

    public void imprimirGrafo() {
        for (String vertice : adjacencias.keySet()) {
            System.out.println(vertice + " -> " + adjacencias.get(vertice));
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");

        grafo.adicionarAresta("A", "B");
        grafo.adicionarAresta("A", "C");
        grafo.adicionarAresta("B", "D");
        grafo.adicionarAresta("C", "D");

        grafo.imprimirGrafo();
    }
}
