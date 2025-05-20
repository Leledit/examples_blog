import java.util.*;

public class BuscaGrafos {
    private Map<Integer, List<Integer>> grafo = new HashMap<>();

    public void adicionarAresta(int origem, int destino) {
        grafo.computeIfAbsent(origem, k -> new ArrayList<>()).add(destino);
    }

    public void dfs(int atual, Set<Integer> visitados) {
        if (visitados.contains(atual)) return;

        visitados.add(atual);
        System.out.println("Visitando: " + atual);

        for (int vizinho : grafo.getOrDefault(atual, new ArrayList<>())) {
            dfs(vizinho, visitados);
        }
    }

    public static void main(String[] args) {
        BuscaGrafos dfs = new BuscaGrafos();
        dfs.adicionarAresta(0, 1);
        dfs.adicionarAresta(0, 2);
        dfs.adicionarAresta(1, 3);
        dfs.adicionarAresta(2, 4);

        dfs.dfs(0, new HashSet<>());
    }
}
