class No {
    int valor;
    No esquerdo, direito;

    public No(int valor) {
        this.valor = valor;
        esquerdo = direito = null;
    }
}

public class ArvoreBST {
    public No raiz;

    public boolean buscar(No no, int alvo) {
        if (no == null) return false;

        if (no.valor == alvo) return true;
        if (alvo < no.valor)
            return buscar(no.esquerdo, alvo);
        else
            return buscar(no.direito, alvo);
    }

    public static void main(String[] args) {
        ArvoreBST bst = new ArvoreBST();
        bst.raiz = new No(10);
        bst.raiz.esquerdo = new No(5);
        bst.raiz.direito = new No(15);
        bst.raiz.esquerdo.esquerdo = new No(2);

        boolean encontrado = bst.buscar(bst.raiz, 2);
        System.out.println("Encontrado? " + encontrado);
    }
}
