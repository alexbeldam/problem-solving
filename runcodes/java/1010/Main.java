import java.util.Scanner;
import java.util.Arrays;

class NenhumItemException extends RuntimeException {
    public NenhumItemException() {
        super("NenhumItemException");
    }
}

class PosicaoInvalidaException extends RuntimeException {
    public PosicaoInvalidaException() {
        super("PosicaoInvalidaException");
    }
}

interface ListaComum<T> {
    T getItem( );               // throws NenhumItemException
    int tamanho();
    boolean vazia();
    Object[] toArray();     
    T[] toArray(T[] x);         // throws NenhumItemException
}

abstract class ListaComumAbstrata<T> implements ListaComum<T> {
    @Override
    public final boolean vazia() {
        return tamanho() == 0;
    }
}

@SuppressWarnings("unchecked")
abstract class ListaComumAbstrataArray<T> extends ListaComumAbstrata<T> {
    private static final int INITIAL_CAPACITY;

    static {
        INITIAL_CAPACITY = 10;
    }

    protected Object[] items;

    protected ListaComumAbstrataArray() {
        items = new Object[INITIAL_CAPACITY];
    }

    protected void resizeItems() {
        int size = tamanho();

        if (items.length == size)
            items = Arrays.copyOf(items, size * 2);
    }

    @Override
    public final int tamanho() {
        int i;

        for (i = 0; i < items.length; i++)
            if (items[i] == null)
                break;

        return i;
    }

    @Override
    public Object[] toArray() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        return Arrays.copyOf(items, size);
    }

    @Override
    public T[] toArray(T[] array) {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        if (array.length < size)
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");

        for (int i = 0; i < size; i++)
            array[i] = (T) items[i];

        return array;
    }
}

abstract class ListaComumAbstrataEncadeada<T> extends ListaComumAbstrata<T> {
    protected class Node {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(T item) {
            this(item, null);
        }

        public T getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

interface ListaBasica<T> extends ListaComum<T> {
    void adicionar(T item);
    T remover();           // throws NenhumItemException
}

interface Pilha<T> extends ListaComum<T> {
    void empilhar(T item);
    T desempilhar();            // throws NenhumItemException   
}

class PilhaEncadeada<T> extends ListaComumAbstrataEncadeada<T> implements Pilha<T> {
    private Node peek;

    public PilhaEncadeada() {}

    @Override
    public void empilhar(T item) {
        Node node = new Node(item, peek);

        peek = node;
    }

    @Override
    public T desempilhar() {
        if (vazia())
            throw new NenhumItemException();

        Node aux = peek;

        peek = peek.getNext();

        return aux.getItem();
    }

    @Override
    public T getItem() {
        if (vazia())
            throw new NenhumItemException();
        return peek.getItem();
    }

    @Override
    public int tamanho() {
        Node aux = peek;
        int size = 0;

        while(aux != null) {
            size++;

            aux = aux.getNext();
        }

        return size;
    }

    @Override
    public Object[] toArray() {
        int size = tamanho();

        if (size == 0)
            return null;

        Object array[] = new Object[size];

        Node aux = peek;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }

    @Override
    public T[] toArray(T[] array) {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        if (array.length != size)
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");

        Node aux = peek;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }
}

@SuppressWarnings("unchecked")
class PilhaArray<T> extends ListaComumAbstrataArray<T> implements Pilha<T> {
    @Override
    public void empilhar(T item) {
        resizeItems();

        items[tamanho()] = item;
    }

    @Override
    public T desempilhar() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();

        int i = size - 1;
        Object aux = items[i];
        items[i] = null;

        return (T) aux;
    }

    @Override
    public T getItem() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        return (T) items[size - 1];
    }
    
    @Override
    public Object[] toArray() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();

        Object[] array = new Object[size];

        for (int i = 0; i < size; i++)
            array[i] = items[size - 1 - i];

        return array;
    }

    @Override
    public T[] toArray(T[] array) {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        if (array.length != size)
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");

        for (int i = 0; i < size; i++)
            array[i] = (T) items[size - 1 - i];

        return array;
    }
}

interface Fila<T> extends ListaComum<T> {
    void enfileirar(T item);
    T desenfileirar();     // throws NenhumItemException
}

class FilaEncadeada<T> extends ListaComumAbstrataEncadeada<T> implements Fila<T> {
    private Node first;
    private Node last;

    public FilaEncadeada() {}

    @Override
    public void enfileirar(T item) {
        Node node = new Node(item);

        if (vazia())
            first = node;
        else
            last.setNext(node);

        last = node;
    }

    @Override
    public T desenfileirar() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        
        Node aux = first;

        if (size == 1)
            last = null;

        first = first.getNext();

        return aux.getItem();
    }

    @Override
    public T getItem() {
        if (vazia())
            throw new NenhumItemException();
        return first.getItem();
    }

    @Override
    public int tamanho() {
        Node aux = first;
        int size = 0;

        while(aux != null) {
            size++;

            aux = aux.getNext();
        }

        return size;
    }

    @Override
    public Object[] toArray() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        
        Object array[] = new Object[size];

        Node aux = first;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }

    @Override
    public T[] toArray(T[] array) {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        if (array.length != size)
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");

        Node aux = first;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }
}

@SuppressWarnings("unchecked")
class FilaArray<T> extends ListaComumAbstrataArray<T> implements Fila<T> {
    @Override
    public void enfileirar(T item) {
        resizeItems();

        items[tamanho()] = item;
    }

    @Override
    public T desenfileirar() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();

        Object aux = items[0];
        items[0] = null;

        for (int i  = 0; i < size; i++) 
            items[i] = items[i + 1];

        return (T) aux;
    }

    @Override
    public T getItem() {
        if (vazia())
            throw new NenhumItemException();
        return (T) items[0];
    }
}

interface Lista<T> extends ListaBasica<T> {
    void adicionarInicio(T item);
    void adicionarFim(T item);
    void adicionar(T item, int posicao);   // throws PosicaoInvalidaException
    T removerInicio();         // throws NenhumItemException
    T removerFim();            // throws NenhumItemException
    T remover(int posicao);    // throws NenhumItemException, PosicaoInvalidaExeption
    T getItem(int posicao);    // throws PosicaoInvalidaExeption
}

class ListaEncadeada<T> extends ListaComumAbstrataEncadeada<T> implements Lista<T> {
    private Node first;
    private Node last;

    public ListaEncadeada() {}

    @Override
    public void adicionarFim(T item) {
        Node node = new Node(item);

        if (vazia()) 
            first = node;
        else
            last.setNext(node);

        last = node;
    }

    @Override
    public void adicionarInicio(T item) {
        Node node = new Node(item, first);

        if (vazia())
            last = node;

        first = node;
    }

    @Override
    public void adicionar(T item) {
        adicionarFim(item);
    }

    @Override
    public void adicionar(T valor, int posicao) {
        int size = tamanho();

        if (posicao < 0 || posicao > size) 
            throw new PosicaoInvalidaException();

        if (posicao == 0) {
            adicionarInicio(valor);
            return;
        }
        if (posicao == size) {
            adicionarFim(valor);
            return;
        }

        Node previous = getNode(posicao - 1);
        Node current = previous.getNext();
        Node node = new Node(valor, current);

        previous.setNext(node);
    }

    @Override
    public T removerInicio() {
        int size = tamanho();

        if (size == 0) 
            throw new NenhumItemException();

        Node aux = first;

        if (size == 1)
            last = null;

        first = first.getNext();

        return aux.getItem();
    }

    @Override
    public T removerFim() {
        int size = tamanho();

        if (tamanho() == 0) 
            throw new NenhumItemException();

        Node aux = last;

        if (size == 1)
            first = last = null;
        else {
            Node prev = getNode(size - 2);

            prev.setNext(null);

            last = prev;
        }

        return aux.getItem();
    }

    @Override
    public T remover(int posicao) {
        int size = tamanho();

        if (size == 0) 
            throw new NenhumItemException();
        else if (posicao < 0 || posicao >= size) 
            throw new PosicaoInvalidaException();

        if (posicao == 0)
            return removerInicio();
        if (posicao == size - 1)
            return removerFim();

        Node aux = getNode(posicao);
        Node prev = getNode(posicao - 1);

        prev.setNext(aux.getNext());

        return aux.getItem();
    }

    private Node getNode(int index) {
        Node aux = first;

        for (int i = 0; i < index; i++)
            aux = aux.getNext();

        return aux;
    }

    @Override
    public final T remover() {
        return removerInicio();
    }

    @Override
    public T getItem(int posicao) {
        int size = tamanho();

        if (size == 0) 
            throw new NenhumItemException();
        else if (posicao < 0 || posicao >= size) 
            throw new PosicaoInvalidaException();

        return getNode(posicao).getItem();
    }

    @Override
    public T getItem() {
        return getItem(0);
    }

    @Override
    public Object[] toArray() {
        int size = tamanho();

        if (size == 0)
            return null;

        Object[] array = new Object[size];

        Node aux = first;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }

    @Override
    public T[] toArray(T[] array) {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        if (array.length != size)
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");

        Node aux = first;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }

    @Override
    public int tamanho() {
        Node aux = first;
        int size = 0;

        while(aux != null) {
            size++;

            aux = aux.getNext();
        }

        return size;
    }
}

@SuppressWarnings("unchecked")
class ListaArray<T> extends ListaComumAbstrataArray<T> implements Lista<T> {
    @Override
    public void adicionarInicio(T item) {
        adicionar(item, 0);
    }

    @Override
    public void adicionarFim(T item) {
        resizeItems();

        items[tamanho()] = item;
    }

    @Override
    public void adicionar(T item, int posicao) {
        int size = tamanho();

        if (posicao < 0 || posicao > size) 
            throw new PosicaoInvalidaException();

        resizeItems();

        if (posicao == size) {
            adicionarFim(item);
            return;
        }

        for (int i = size; i > posicao; i--)
            items[i] = items[i - 1];

        items[posicao] = item;
    }

    @Override
    public void adicionar(T item) {
        adicionarFim(item);
    }

    @Override
    public T removerInicio() {
        return remover(0);
    }

    @Override
    public T removerFim() {
        if (vazia())
            throw new NenhumItemException();

        int i = tamanho() - 1;
        Object aux = items[i];
        items[i] = null;

        return (T) aux;
    }

    @Override
    public T remover(int posicao) {
        int size = tamanho();
        
        if (size == 0) 
            throw new NenhumItemException();
        else if (posicao < 0 || posicao >= size) 
            throw new PosicaoInvalidaException();

        if (posicao == size - 1)
            return removerFim();

        Object aux = items[posicao];

        for (int i = posicao; i < size; i++)
            items[i] = items[i + 1];

        return (T) aux;
    }

    @Override
    public T remover() {
        return removerInicio();
    }

    @Override
    public T getItem(int posicao) {
        int size = tamanho();

        if (size == 0) 
            throw new NenhumItemException();
        else if (posicao < 0 || posicao >= size) 
            throw new PosicaoInvalidaException();

        return (T) items[posicao];
    }
    
    @Override
    public T getItem() {
        return getItem(0);
    }
}

class PilhaAdapter<T> implements ListaBasica<T> {
    
    private final Pilha<T> pilha;

    public PilhaAdapter(Pilha<T> pilha) {
        this.pilha = pilha;
    }    
    
    @Override
    public void adicionar(T item) {
        pilha.empilhar(item);
    }

    @Override
    public T remover() {
        return pilha.desempilhar();
    }

    @Override
    public T getItem() {
        return pilha.getItem();
    }

    @Override
    public int tamanho() {
        return pilha.tamanho();
    }

    @Override
    public boolean vazia() {
        return pilha.vazia();
    }

    @Override
    public Object[] toArray() {
        return pilha.toArray();
    }

    @Override
    public T[] toArray(T[] items) {
        return pilha.toArray(items);
    }    
}

class FilaAdapter<T> implements ListaBasica<T> {
    private final Fila<T> fila;

    public FilaAdapter(Fila<T> fila) {
        this.fila = fila;
    }

    @Override
    public T getItem() {
        return fila.getItem();
    }

    @Override
    public int tamanho() {
        return fila.tamanho();
    }

    @Override
    public boolean vazia() {
        return fila.vazia();
    }

    @Override
    public Object[] toArray() {
        return fila.toArray();
    }

    @Override
    public void adicionar(T item) {
        fila.enfileirar(item);
    }

    @Override
    public T remover() {
        return fila.desenfileirar();
    }

    @Override
    public T[] toArray(T[] items) {
        return fila.toArray(items);
    }  
}

class Main {

    private final ListaBasica<Integer> lista;
    
    public Main(ListaBasica<Integer> lista) {
        this.lista = lista;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Integer valor;
        
        token = in.next();
        
        switch (token) {
            case "PE": main = new Main(new PilhaAdapter<>(new PilhaEncadeada<>())); break;
            case "PA": main = new Main(new PilhaAdapter<>(new PilhaArray<>())); break;
            case "FE": main = new Main(new FilaAdapter<>(new FilaEncadeada<>())); break;
            case "FA": main = new Main(new FilaAdapter<>(new FilaArray<>())); break;
            case "LE": main = new Main(new ListaEncadeada<>()); break;
            default: main = new Main(new ListaArray<>());
        }

        while (!token.equals("Q")) {
            switch(token) {
                case "A":   // adiciona um item
                    valor = in.nextInt();
                    main.lista.adicionar(valor);
                    break;      
                case "R":   // remove um item
                    try {
                        main.lista.remover();
                    } catch(NenhumItemException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "G":   // retorna um item, sem remover
                    try {
                        valor = main.lista.getItem();
                        System.out.println(valor);
                    } catch (NenhumItemException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "T":   // numero de itens na estrutura
                    System.out.println(main.lista.tamanho());
                    break;
                case "V":   // indica se a estrutura esta vazia
                    System.out.println(main.lista.vazia());
                    break;
                case "P":   // imprime os itens da estrutura, sem remover
                    try {
                        Integer valores[] = new Integer[main.lista.tamanho()];
                        valores = main.lista.toArray(valores);
                        if (valores != null) 
                            for(Integer item: valores)
                                System.out.println(item);
                    } catch (NenhumItemException e) {
                    }    
                    break;
            }
            token = in.next();
        }
        in.close();
    }
}
