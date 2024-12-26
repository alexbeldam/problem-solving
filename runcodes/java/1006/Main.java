import java.util.Arrays;
import java.util.Scanner;

abstract class Fila {
    protected int size;

    public Fila() {
        size = 0;
    }

    /**
     * Adiciona @code{item} no final da fila.
     */
    public abstract void enfileirar(Object item);
    
    /**
     * Remove um @code{item} no início da fila.
     * return @code{item} no início da fila ou @code{null} se a fila estiver vazia.
    */
    public abstract Object desenfileirar();
    
    /**
     * Recupera @code{item} no início da fila, sem remover.
     * @return @code{item} no início da fila ou @code{null} se a fila estiver vazia.
     */
    public abstract Object getItem();
    
    /**
     * Recupera número de itens na fila.
     * @return Número de itens mantidos na fila.
     */
    public final int tamanho() {
        return size;
    }
    
    /**
     * Retorna @code{true} se a fila não possuir qualquer @code{item}.
     * @return @code{true} se a fila não possuir qualquer @code{item}, 
     * ou @code{false} se possuir.
     */
    public final boolean estaVazia() {
        return size == 0;
    }
    
    /**
     * Retorna um array contendo todos os elementos da fila.
     * @return um array com todos os elementos da fila @code{null} se a fila estiver vazia.
     */
    public abstract Object[] toArray();
}

class FilaEncadeada extends Fila {
    private static class Node {
        private Object item;
        private Node next;

        public Node(Object item) {
            this.item = item;
            next = null;
        }

        public Object getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node first;
    private Node last;

    public FilaEncadeada() {
        first = last = null;
    }

    @Override
    public void enfileirar(Object item) {
        Node node = new Node(item);

        if (estaVazia())
            first = node;
        else
            last.setNext(node);

        last = node;
        size++;
    }

    @Override
    public Object desenfileirar() {
        if (estaVazia())
            return null;

        Node aux = first;

        if (size == 1)
            last = null;

        first = first.getNext();
        size--;

        return aux.getItem();
    }

    @Override
    public Object getItem() {
        if (estaVazia())
            return null;
        return first.getItem();
    }

    @Override
    public Object[] toArray() {
        if (estaVazia())
            return null;
        
        Object array[] = new Object[size];

        Node aux = first;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }
}

class FilaArray extends Fila {
    private static final int INITIAL_LENGTH = 10;

    private Object[] items;

    public FilaArray() {
        items = new Object[INITIAL_LENGTH];
    }

    @Override
    public void enfileirar(Object item) {
        if (size == items.length)
            items = Arrays.copyOf(items, items.length * 2);

        items[size] = item;
        size++;
    }

    @Override
    public Object desenfileirar() {
        if (estaVazia())
            return null;
        
        Object aux = items[0];

        size--;
        
        for (int i  = 0; i < size; i++) 
            items[i] = items[i + 1];

        return aux;
    }

    @Override
    public Object getItem() {
        if (estaVazia())
            return null;
        return items[0];
    }

    @Override
    public Object[] toArray() {
        if (estaVazia())
            return null;
        return Arrays.copyOf(items, size);
    }
}

class Main {

    private Fila fila;

    public Main(Fila fila){
        this.fila = fila;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Object valor;
        
        token = in.next();
        if (token.equals("FE"))
            main = new Main(new FilaEncadeada());
        else
            main = new Main(new FilaArray());

        
        while (!token.equals("Q")) {
            switch(token) {
                case "AF":
                    valor = in.nextInt();
                    main.fila.enfileirar(valor);
                    break;
                case "RI":
                    valor = main.fila.desenfileirar();
                    if (valor == null)
                        System.out.println("NenhumItemException");
                    break;
                case "G":
                    valor = main.fila.getItem();
                    if (valor != null)
                        System.out.println(valor);
                    else
                        System.out.println("NenhumItemException");
                    break;
                case "T":
                    System.out.println(main.fila.tamanho());
                    break;
                case "V":
                    System.out.println(main.fila.estaVazia());
                    break;
                case "P":
                    Object valores[] = main.fila.toArray();
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
