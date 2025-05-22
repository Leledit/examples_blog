public class Matrizes {
    public static int[][] matrizQuadrada(int n) {
        int[][] matriz = new int[n][n];
        int valor = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = valor++;
            }
        }
        return matriz;
    }

    public static int[][] matrizIdentidade(int n) {
        int[][] identidade = new int[n][n];
        for (int i = 0; i < n; i++) {
            identidade[i][i] = 1;
        }
        return identidade;
    }

    public static int[][] matrizDiagonal(int[] diagonal) {
        int n = diagonal.length;
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            matriz[i][i] = diagonal[i];
        }
        return matriz;
    }

    public static int[][] matrizTriangularSuperior(int n) {
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                matriz[i][j] = i + j;
            }
        }
        return matriz;
    }

    public static int[][] transporMatriz(int[][] matriz) {
        int n = matriz.length;
        int[][] transposta = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }
        return transposta;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                System.out.printf("%4d", elemento);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int tamanho = 4;

        System.out.println("Matriz Quadrada:");
        imprimirMatriz(matrizQuadrada(tamanho));

        System.out.println("Matriz Identidade:");
        imprimirMatriz(matrizIdentidade(tamanho));

        System.out.println("Matriz Diagonal:");
        int[] valoresDiag = {3, 6, 9, 12};
        imprimirMatriz(matrizDiagonal(valoresDiag));

        System.out.println("Matriz Triangular Superior:");
        imprimirMatriz(matrizTriangularSuperior(tamanho));

        System.out.println("Transposta da Matriz Quadrada:");
        int[][] quadrada = matrizQuadrada(tamanho);
        imprimirMatriz(transporMatriz(quadrada));
    }

}
