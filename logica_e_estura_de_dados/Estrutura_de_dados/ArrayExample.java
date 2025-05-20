public class ArrayExample {

    public static void main(String[] args) {
        int[] numeros = new int[5];

        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        System.out.println("Elemento no índice 2: " + numeros[2]);

        System.out.print("Todos os elementos: ");
        imprimirArray(numeros);

        int valorBuscado = 30;
        int indice = buscarElemento(numeros, valorBuscado);
        if (indice != -1) {
            System.out.println("Elemento " + valorBuscado + " encontrado no índice " + indice);
        } else {
            System.out.println("Elemento " + valorBuscado + " não encontrado.");
        }
    }

    private static void imprimirArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    private static int buscarElemento(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}
