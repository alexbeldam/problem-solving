import java.util.Arrays;
import java.util.Scanner;

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

interface ListaComum {
    Object getItem();  //throws NenhumItemException
    int tamanho();
    boolean vazia();
    Object[] toArray(); //throws NenhumItemException
}

abstract class ListaComumAbstrata implements ListaComum {
    @Override
    public final boolean vazia() {
        return tamanho() == 0;
    }
}

abstract class ListaComumAbstrataArray extends ListaComumAbstrata {
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
            return null;
        return Arrays.copyOf(items, size);
    }
}

abstract class ListaComumAbstrataEncadeada extends ListaComumAbstrata {
    protected static class Node {
        private Object item;
        private Node next;

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(Object item) {
            this(item, null);
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
}

interface ListaBasica extends ListaComum {
    void adicionar(Object item);
    Object remover(); //throws NenhumItemException   
}

interface Pilha extends ListaComum {
    void empilhar(Object item);
    Object desempilhar(); //throws NenhumItemException
}

class PilhaEncadeada extends ListaComumAbstrataEncadeada implements Pilha {
    private Node peek;

    public PilhaEncadeada() {}

    @Override
    public void empilhar(Object item) {
        Node node = new Node(item, peek);

        peek = node;
    }

    @Override
    public Object desempilhar() {
        if (vazia())
            throw new NenhumItemException();

        Node aux = peek;

        peek = peek.getNext();

        return aux.getItem();
    }

    @Override
    public Object getItem() {
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
}

class PilhaArray extends ListaComumAbstrataArray implements Pilha {
    @Override
    public void empilhar(Object item) {
        resizeItems();

        items[tamanho()] = item;
    }

    @Override
    public Object desempilhar() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();

        int i = size - 1;
        Object aux = items[i];
        items[i] = null;

        return aux;
    }

    @Override
    public Object getItem() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();
        return items[size - 1];
    }
    
    @Override
    public Object[] toArray() {
        int size = tamanho();

        if (size == 0)
            return null;

        Object[] array = new Object[size];

        for (int i = 0; i < size; i++)
            array[i] = items[size - 1 - i];

        return array;
    }
}

interface Fila extends ListaComum {
    void enfileirar(Object item);
    Object desenfileirar(); //throws NenhumItemException    
}

class FilaEncadeada extends ListaComumAbstrataEncadeada implements Fila {
    private Node first;
    private Node last;

    public FilaEncadeada() {}

    @Override
    public void enfileirar(Object item) {
        Node node = new Node(item);

        if (vazia())
            first = node;
        else
            last.setNext(node);

        last = node;
    }

    @Override
    public Object desenfileirar() {
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
    public Object getItem() {
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

class FilaArray extends ListaComumAbstrataArray implements Fila {
    @Override
    public void enfileirar(Object item) {
        resizeItems();

        items[tamanho()] = item;
    }

    @Override
    public Object desenfileirar() {
        int size = tamanho();

        if (size == 0)
            throw new NenhumItemException();

        Object aux = items[0];
        items[0] = null;

        for (int i  = 0; i < size; i++) 
            items[i] = items[i + 1];

        return aux;
    }

    @Override
    public Object getItem() {
        if (vazia())
            throw new NenhumItemException();
        return items[0];
    }
}

// FAZER O MESMO QUE FOI FEITO PARA Pilha

interface Lista extends ListaBasica {
    void adicionarInicio(Object item);
    void adicionarFim(Object item);
    void adicionar(Object item, int posicao);   // throws PosicaoInvalidaException
    Object removerInicio(); //throws NenhumItemException
    Object removerFim(); //throws NenhumItemException         
    Object remover(int posicao);   // throws NenhumItemException, PosicaoInvalidaExeption
    Object getItem(int posicao);    // throws PosicaoInvalidaExeption
}

class ListaEncadeada extends ListaComumAbstrataEncadeada implements Lista {
    private Node first;
    private Node last;

    public ListaEncadeada() {}

    @Override
    public void adicionarFim(Object item) {
        Node node = new Node(item);

        if (vazia()) 
            first = node;
        else
            last.setNext(node);

        last = node;
    }

    @Override
    public void adicionarInicio(Object item) {
        Node node = new Node(item, first);

        if (vazia())
            last = node;

        first = node;
    }

    @Override
    public void adicionar(Object item) {
        adicionarFim(item);
    }

    @Override
    public void adicionar(Object valor, int posicao) {
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
    public Object removerInicio() {
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
    public Object removerFim() {
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
    public Object remover(int posicao) {
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
    public final Object remover() {
        return removerInicio();
    }

    @Override
    public Object getItem(int posicao) {
        int size = tamanho();

        if (size == 0) 
            throw new NenhumItemException();
        else if (posicao < 0 || posicao >= size) 
            throw new PosicaoInvalidaException();

        return getNode(posicao).getItem();
    }

    @Override
    public Object getItem() {
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

class ListaArray extends ListaComumAbstrataArray implements Lista {
    @Override
    public void adicionarInicio(Object item) {
        adicionar(item, 0);
    }

    @Override
    public void adicionarFim(Object item) {
        resizeItems();

        items[tamanho()] = item;
    }

    @Override
    public void adicionar(Object item, int posicao) {
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
    public void adicionar(Object item) {
        adicionarFim(item);
    }

    @Override
    public Object removerInicio() {
        return remover(0);
    }

    @Override
    public Object removerFim() {
        if (vazia())
            throw new NenhumItemException();

        int i = tamanho() - 1;
        Object aux = items[i];
        items[i] = null;

        return aux;
    }

    @Override
    public Object remover(int posicao) {
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

        return aux;
    }

    @Override
    public Object remover() {
        return removerInicio();
    }

    @Override
    public Object getItem(int posicao) {
        int size = tamanho();

        if (size == 0) 
            throw new NenhumItemException();
        else if (posicao < 0 || posicao >= size) 
            throw new PosicaoInvalidaException();

        return items[posicao];
    }
    
    @Override
    public Object getItem() {
        return getItem(0);
    }
}

class PilhaAdapter implements ListaBasica {
    
    private final Pilha pilha;

    public PilhaAdapter(Pilha pilha) {
        this.pilha = pilha;
    }    
    
    @Override
    public void adicionar(Object item) {
        pilha.empilhar(item);
    }

    @Override
    public Object remover() {
        return pilha.desempilhar();
    }

    @Override
    public Object getItem() {
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
}

class FilaAdapter extends ListaComumAbstrata implements ListaBasica {
    private final Fila fila;

    public FilaAdapter(Fila fila) {
        this.fila = fila;
    }

    @Override
    public Object getItem() {
        return fila.getItem();
    }

    @Override
    public int tamanho() {
        return fila.tamanho();
    }

    @Override
    public Object[] toArray() {
        return fila.toArray();
    }

    @Override
    public void adicionar(Object item) {
        fila.enfileirar(item);;
    }

    @Override
    public Object remover() {
        return fila.desenfileirar();
    }
}

class Main {

    private final ListaBasica lista;
    
    public Main(ListaBasica lista) {
        this.lista = lista;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Object valor;
        
        token = in.next();
        
        switch (token) {
            case "PE": main = new Main(new PilhaAdapter(new PilhaEncadeada())); break;
            case "PA": main = new Main(new PilhaAdapter(new PilhaArray())); break;
            case "FE": main = new Main(new FilaAdapter(new FilaEncadeada())); break;
            case "FA": main = new Main(new FilaAdapter(new FilaArray())); break;
            case "LE": main = new Main(new ListaEncadeada()); break;
            default: main = new Main(new ListaArray());
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
                        Object valores[] = main.lista.toArray();
                        if (valores != null) 
                            for(Object item : valores)
                                System.out.println(item);
                    } catch (NenhumItemException e) {
                        System.out.println(e.getMessage());
                    }    
                    break;
            }
            token = in.next();
        }
        in.close();
    }
}