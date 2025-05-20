
public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void inserir(int valor) {
        Node novo = new Node(valor);
        if (head == null) {
            head = novo;
        } else {
            Node atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void remover(int valor) {
        if (head == null) return;

        if (head.valor == valor) {
            head = head.proximo;
            return;
        }

        Node atual = head;
        while (atual.proximo != null && atual.proximo.valor != valor) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
        }
    }

    public void imprimir() {
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public boolean contem(int valor) {
        Node atual = head;
        while (atual != null) {
            if (atual.valor == valor) return true;
            atual = atual.proximo;
        }
        return false;
    }

    public class Node {
        int valor;
        Node proximo;

        public Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }
}

public void main(String[] args) {
    LinkedList lista = new LinkedList();

    lista.inserir(10);
    lista.inserir(20);
    lista.inserir(30);
    lista.inserir(40);

    System.out.println("Lista atual:");
    lista.imprimir();

    System.out.println("A lista contém 20? " + lista.contem(20));
    System.out.println("A lista contém 50? " + lista.contem(50));

    lista.remover(20);
    System.out.println("Após remover 20:");
    lista.imprimir();
}
