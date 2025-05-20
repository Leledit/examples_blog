public class DequeExample {

    static class Node {
        int valor;
        Node anterior;
        Node proximo;

        public Node(int valor) {
            this.valor = valor;
        }
    }

    static class Deque {
        private Node inicio;
        private Node fim;

        public Deque() {
            this.inicio = null;
            this.fim = null;
        }

        public void inserirInicio(int valor) {
            Node novo = new Node(valor);
            if (estaVazio()) {
                inicio = fim = novo;
            } else {
                novo.proximo = inicio;
                inicio.anterior = novo;
                inicio = novo;
            }
        }

        public void inserirFim(int valor) {
            Node novo = new Node(valor);
            if (estaVazio()) {
                inicio = fim = novo;
            } else {
                fim.proximo = novo;
                novo.anterior = fim;
                fim = novo;
            }
        }

        public int removerInicio() {
            if (estaVazio()) {
                throw new RuntimeException("Deque vazio!");
            }
            int valor = inicio.valor;
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            } else {
                inicio.anterior = null;
            }
            return valor;
        }

        public int removerFim() {
            if (estaVazio()) {
                throw new RuntimeException("Deque vazio!");
            }
            int valor = fim.valor;
            fim = fim.anterior;
            if (fim == null) {
                inicio = null;
            } else {
                fim.proximo = null;
            }
            return valor;
        }

        public int frente() {
            if (estaVazio()) {
                throw new RuntimeException("Deque vazio!");
            }
            return inicio.valor;
        }

        public int tras() {
            if (estaVazio()) {
                throw new RuntimeException("Deque vazio!");
            }
            return fim.valor;
        }

        public boolean estaVazio() {
            return inicio == null;
        }

        public void imprimir() {
            Node atual = inicio;
            System.out.print("Início -> ");
            while (atual != null) {
                System.out.print(atual.valor + " <-> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.inserirFim(10);
        deque.inserirFim(20);
        deque.inserirInicio(5);
        deque.inserirInicio(1);

        System.out.println("Deque após inserções:");
        deque.imprimir();

        System.out.println("Frente: " + deque.frente());
        System.out.println("Trás: " + deque.tras());

        System.out.println("Removendo do início: " + deque.removerInicio());
        System.out.println("Removendo do fim: " + deque.removerFim());

        System.out.println("Deque após remoções:");
        deque.imprimir();

        System.out.println("Deque está vazio? " + deque.estaVazio());
    }
}
