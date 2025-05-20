public class LogicaBooleana {
    public static void main(String[] args) {
        boolean temSenhaCorreta = true;
        boolean temPermissao = false;

        boolean podeAcessar = temSenhaCorreta && temPermissao;

        System.out.println("Acesso permitido? " + podeAcessar);
    }
}
