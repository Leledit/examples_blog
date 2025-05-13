public class LogicaModular {

    public static void main(String[] args) {
        double resultado = calcularMedia(7.0, 9.5);
        exibirResultado(resultado);
    }

    public static double calcularMedia(double a, double b) {
        return (a + b) / 2;
    }

    public static void exibirResultado(double media) {
        System.out.println("A média é: " + media);
    }
}
