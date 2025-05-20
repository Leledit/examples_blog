import java.util.Arrays;

public class BuscaExponencial {
    public static int busca(int[] arr, int alvo) {
        if (arr[0] == alvo) return 0;

        int i = 1;
        while (i < arr.length && arr[i] <= alvo) {
            i *= 2;
        }

        return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), alvo);
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 7, 9, 13, 17, 21, 25};
        int alvo = 13;

        int resultado = busca(numeros, alvo);
        System.out.println("Índice encontrado: " + resultado);
    }
}
