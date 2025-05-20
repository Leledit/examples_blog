import java.util.*;

class Celula implements Comparable<Celula> {
    int x, y;
    int g, h, f;
    Celula anterior;

    public Celula(int x, int y, int g, int h, Celula anterior) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = g + h;
        this.anterior = anterior;
    }

    @Override
    public int compareTo(Celula outra) {
        return Integer.compare(this.f, outra.f);
    }
}

public class BuscaHeurística {

    static int[][] direcoes = { {0,1}, {1,0}, {0,-1}, {-1,0} }; // direita, baixo, esquerda, cima

    public static List<Celula> buscar(int[][] mapa, int[] inicio, int[] fim) {
        int linhas = mapa.length;
        int colunas = mapa[0].length;

        boolean[][] visitado = new boolean[linhas][colunas];
        PriorityQueue<Celula> fila = new PriorityQueue<>();

        Celula inicial = new Celula(inicio[0], inicio[1], 0, heuristica(inicio[0], inicio[1], fim[0], fim[1]), null);
        fila.add(inicial);

        while (!fila.isEmpty()) {
            Celula atual = fila.poll();

            if (atual.x == fim[0] && atual.y == fim[1]) {
                return reconstruirCaminho(atual);
            }

            visitado[atual.x][atual.y] = true;

            for (int[] dir : direcoes) {
                int novoX = atual.x + dir[0];
                int novoY = atual.y + dir[1];

                if (valido(novoX, novoY, mapa, visitado)) {
                    int gNovo = atual.g + 1;
                    int hNovo = heuristica(novoX, novoY, fim[0], fim[1]);
                    Celula vizinha = new Celula(novoX, novoY, gNovo, hNovo, atual);
                    fila.add(vizinha);
                }
            }
        }

        return null; // Caminho não encontrado
    }

    static int heuristica(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2); // Distância de Manhattan
    }

    static boolean valido(int x, int y, int[][] mapa, boolean[][] visitado) {
        return x >= 0 && x < mapa.length &&
                y >= 0 && y < mapa[0].length &&
                mapa[x][y] == 0 && !visitado[x][y];
    }

    static List<Celula> reconstruirCaminho(Celula destino) {
        List<Celula> caminho = new ArrayList<>();
        for (Celula atual = destino; atual != null; atual = atual.anterior) {
            caminho.add(atual);
        }
        Collections.reverse(caminho);
        return caminho;
    }

    public static void main(String[] args) {
        int[][] mapa = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[] inicio = {0, 0};
        int[] fim = {4, 4};

        List<Celula> caminho = buscar(mapa, inicio, fim);

        if (caminho != null) {
            System.out.println("Caminho encontrado:");
            for (Celula c : caminho) {
                System.out.printf("(%d, %d) ", c.x, c.y);
            }
        } else {
            System.out.println("Nenhum caminho encontrado.");
        }
    }
}