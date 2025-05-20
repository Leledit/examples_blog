public class Queue {

    static class Node {
        int valor;
        Node proximo;

        public Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    static class Fila {
        private Node inicio;
        private Node fim;

        public Fila() {
            this.inicio = null;
            this.fim = null;
        }

        public void enfileirar(int valor) {
            Node novo = new Node(valor);
            if (estaVazia()) {
                inicio = novo;
                fim = novo;
            } else {
                fim.proximo = novo;
                fim = novo;
            }
        }

        public int desenfileirar() {
            if (estaVazia()) {
                throw new RuntimeException("Fila vazia!");
            }
            int valor = inicio.valor;
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
            return valor;
        }

        public int frente() {
            if (estaVazia()) {
                throw new RuntimeException("Fila vazia!");
            }
            return inicio.valor;
        }

        public boolean estaVazia() {
            return inicio == null;
        }

        public void imprimir() {
            Node atual = inicio;
            System.out.print("Frente -> ");
            while (atual != null) {
                System.out.print(atual.valor + " -> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Fila fila = new Fila();

        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);

        System.out.println("Fila atual:");
        fila.imprimir();

        System.out.println("Elemento na frente: " + fila.frente());

        System.out.println("Desenfileirando: " + fila.desenfileirar());

        System.out.println("Fila após desenfileirar:");
        fila.imprimir();

        System.out.println("Fila está vazia? " + fila.estaVazia());
    }
}
