public class BuscaLinear {
    public static int buscar(int[] arr, int alvo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == alvo) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 4, 2};
        int alvo = 4;

        int resultado = buscar(numeros, alvo);
        System.out.println("Índice encontrado: " + resultado);
    }
}
