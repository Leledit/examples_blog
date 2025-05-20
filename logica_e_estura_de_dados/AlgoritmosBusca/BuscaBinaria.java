public class BuscaBinaria {
    public static int buscar(int[] arr, int alvo) {
        int inicio = 0;
        int fim = arr.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (arr[meio] == alvo) {
                return meio;
            } else if (arr[meio] < alvo) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 3, 4, 5, 8};
        int alvo = 8;

        int resultado = buscar(numeros, alvo);
        System.out.println("Índice encontrado: " + resultado);
    }
}
