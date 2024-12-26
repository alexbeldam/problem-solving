import java.util.Arrays;
import java.util.Scanner;

abstract class Pilha {
    protected int size;

    public Pilha() {
        size = 0;
    }

    /**
     * Adiciona <code>item</code> no final da pilha.
     */
    public abstract void empilhar(Object item);
    
    /**
     * Remove um <code>item</code> no topo da pilha.
     * return <code>item</code> no topo da pilha ou <code>null</code> se a pilha estiver vazia.
    */
    public abstract Object desempilhar();
    /**
     * Recupera <code>item</code> no topo da pilha, sem remover.
     * @return <code>item</code> no topo da pilha ou <code>null</code> se a pilha estiver vazia.
     */
    public abstract Object getItem();
    
    /**
     * Recupera número de itens na pilha.
     * @return Número de itens mantidos na pilha.
     */
    public final int tamanho() {
        return size;
    }
    
    /**
     * Retorna <code>true</code> se a pilha não possuir qualquer <code>item</code>.
     * @return <code>true</code> se a pilha não possuir qualquer <code>item</code>, 
     * ou <code>false</code> se possuir.
     */
    public final boolean vazia() {
        return size == 0;
    }
    
    /**
     * Retorna um array contendo todos os itens da pilha.
     * @return um array com todos os elementos da pilha <code>null</code> se a pilha estiver vazia.
     */
    public abstract Object[] toArray();
}

class PilhaEncadeada extends Pilha {
    private static class Node {
        private Object item;
        private Node previous;

        public Node(Object item, Node previous) {
            this.item = item;
            this.previous = previous;
        }

        public Object getItem() {
            return item;
        }

        public Node getPrevious() {
            return previous;
        }
    }
    
    private Node peek;

    public PilhaEncadeada() {
        peek = null;
    }

    @Override
    public void empilhar(Object item) {
        Node node = new Node(item, peek);

        peek = node;
        size++;
    }

    @Override
    public Object desempilhar() {
        if (vazia())
            return null;
        
        Node aux = peek;

        peek = peek.getPrevious();
        size--;

        return aux.getItem();
    }

    @Override
    public Object getItem() {
        if (vazia())
            return null;
        return peek.getItem();
    }

    @Override
    public Object[] toArray() {
        if (vazia())
            return null;

        Object array[] = new Object[size];

        Node aux = peek;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getPrevious();
        }

        return array;
    }
}

class PilhaArray extends Pilha {
    private static final int INITIAL_LENGTH = 10;

    private Object[] items;

    public PilhaArray() {
        items = new Object[INITIAL_LENGTH];
    }

    @Override
    public void empilhar(Object item) {
        if (size == items.length)
            items = Arrays.copyOf(items, items.length * 2);

        items[size] = item;
        size++;
    }

    @Override
    public Object desempilhar() {
        if (vazia())
            return null;
        return items[--size];
    }

    @Override
    public Object getItem() {
        if (vazia())
            return null;
        return items[size - 1];
    }

    @Override
    public Object[] toArray() {
        if (vazia())
            return null;
        
        Object array[] = new Object[size];

        for (int i = 0; i < size; i++)
            array[i] = items[size - 1 - i];

        return array;
    }
}

class Main {

    private Pilha pilha;

    public Main(Pilha pilha) {
        this.pilha = pilha;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Object valor;
        
        token = in.next();

        if (token.equals("pe"))
            main = new Main(new PilhaEncadeada());
        else
            main = new Main(new PilhaArray());

        while (!token.equals("Q")) {
            switch(token) {
                case "E":
                    valor = in.nextInt();
                    main.pilha.empilhar(valor);
                    break;
                case "D":
                    valor = main.pilha.desempilhar();
                    if (valor == null)
                        System.out.println("NenhumItemException");
                    break;
                case "G":
                    valor = main.pilha.getItem();
                    if (valor != null)
                        System.out.println(valor);
                    else
                        System.out.println("NenhumItemException");
                    break;
                case "T":
                    System.out.println(main.pilha.tamanho());
                    break;
                case "V":
                    System.out.println(main.pilha.vazia());
                    break;
                case "P":
                    Object valores[] = main.pilha.toArray();
                    if (valores != null) {
                        for(Object item: valores)
                            System.out.println(item);
                    }
                    break;
            }
            token = in.next();
        }
    }
}
