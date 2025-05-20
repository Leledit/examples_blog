public class Stack {

    static class Node {
        int valor;
        Node proximo;

        public Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    static class Pilha {
        private Node topo;

        public Pilha() {
            this.topo = null;
        }

        public void empilhar(int valor) {
            Node novo = new Node(valor);
            novo.proximo = topo;
            topo = novo;
        }

        public int desempilhar() {
            if (estaVazia()) {
                throw new RuntimeException("Pilha vazia!");
            }
            int valor = topo.valor;
            topo = topo.proximo;
            return valor;
        }

        public int topo() {
            if (estaVazia()) {
                throw new RuntimeException("Pilha vazia!");
            }
            return topo.valor;
        }

        public boolean estaVazia() {
            return topo == null;
        }

        public void imprimir() {
            Node atual = topo;
            System.out.print("Topo -> ");
            while (atual != null) {
                System.out.print(atual.valor + " -> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.empilhar(10);
        pilha.empilhar(20);
        pilha.empilhar(30);

        System.out.println("Pilha atual:");
        pilha.imprimir();

        System.out.println("Elemento no topo: " + pilha.topo());

        System.out.println("Desempilhando: " + pilha.desempilhar());

        System.out.println("Pilha após desempilhar:");
        pilha.imprimir();

        System.out.println("Pilha está vazia? " + pilha.estaVazia());
    }
}
