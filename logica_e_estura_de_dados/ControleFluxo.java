public class ControleFluxo {
    public static void main(String[] args) {
        exemploIfElse();
        System.out.println();

        exemploSwitch();
        System.out.println();

        exemploFor();
        System.out.println();

        exemploWhile();
        System.out.println();

        exemploDoWhile();
        System.out.println();

        exemploTryCatch();
        System.out.println();
    }

    public static void exemploIfElse() {
        int idade = 18;

        if (idade >= 18) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("Você é menor de idade.");
        }
    }

    public static void exemploSwitch() {
        int dia = 3;

        switch (dia) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda-feira");
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            default:
                System.out.println("Dia inválido");
        }
    }

    public static void exemploFor(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("Contagem: " + i);
        }
    }

    public static void exemploWhile(){
        int contador = 1;

        while (contador <= 5) {
            System.out.println("Contagem: " + contador);
            contador++;
        }
    }

    public static void exemploDoWhile(){
        int contador = 1;

        do {
            System.out.println("Contagem: " + contador);
            contador++;
        } while (contador <= 5);
    }

    public static void exemploTryCatch(){
        try {
            int resultado = 10 / 0; // Causa uma ArithmeticException
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero não é permitida.");
        } finally {
            System.out.println("Bloco 'finally' executado sempre.");
        }
    }
}