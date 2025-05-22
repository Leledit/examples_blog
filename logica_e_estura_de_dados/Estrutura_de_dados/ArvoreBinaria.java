public class ArvoreBinaria {

    static class No {
        int valor;
        No esquerdo, direito;

        public No(int valor) {
            this.valor = valor;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    No raiz;

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = inserirRecursivo(atual.direito, valor);
        }

        return atual;
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerEmOrdemRecursivo(No atual) {
        if (atual != null) {
            percorrerEmOrdemRecursivo(atual.esquerdo);
            System.out.print(atual.valor + " ");
            percorrerEmOrdemRecursivo(atual.direito);
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.print("Percurso em ordem: ");
        arvore.percorrerEmOrdem();
    }
}
