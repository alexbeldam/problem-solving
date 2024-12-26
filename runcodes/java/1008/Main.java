import java.util.Arrays;
import java.util.Scanner;

enum ErroLista {
    INDICE_INVALIDO("PosicaoInvalidaException"),
    VAZIA("NenhumItemException"),
    SEM_ERRO("NenhumErro");
    
    String msgErro;
    
    ErroLista(String msg) {
        msgErro = msg;
    }
    
    public String getMessage() {
        return msgErro;
    }
}

class ErroListaWrapper {
    private ErroLista erro;
    
    public ErroListaWrapper() {
        this(ErroLista.SEM_ERRO);
    }
    
    public ErroListaWrapper(ErroLista erro) {
        this.erro = erro;
    }

    public ErroLista getErro() {
        return erro;
    }

    public void setErro(ErroLista erro) {
        this.erro = erro;
    }
}

interface ILista {
    public abstract void adicionar(Object item);
    public abstract Object remover(ErroListaWrapper erro);
    public abstract Object getItem(ErroListaWrapper erro);
    public abstract int tamanho();
    public abstract boolean vazia();
    public abstract Object[] toArray();
}

abstract class AbstractList implements ILista {
    protected int size;

    public AbstractList() {
        size = 0;
    }

    @Override
    public final int tamanho() {
        return size;
    }

    @Override
    public final boolean vazia() {
        return size == 0;
    }
}

abstract class PilhaAbstrata extends AbstractList {
    public abstract void empilhar(Object item);

    public abstract Object desempilhar(ErroListaWrapper erro);

    @Override
    public final void adicionar(Object item) {
        empilhar(item);
    }

    @Override
    public final Object remover(ErroListaWrapper erro) {
        return desempilhar(erro);
    }
}

class PilhaEncadeada extends PilhaAbstrata {
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
    public Object desempilhar(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        
        Node aux = peek;

        peek = peek.getPrevious();
        size--;

        return aux.getItem();
    }

    @Override
    public Object getItem(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
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

class PilhaArray extends PilhaAbstrata {
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
    public Object desempilhar(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        return items[--size];
    }

    @Override
    public Object getItem(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
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

abstract class FilaAbstrata extends AbstractList {
    public abstract void enfileirar(Object item);

    public abstract Object desenfileirar(ErroListaWrapper erro);

    @Override
    public final void adicionar(Object item) {
        enfileirar(item);
    }

    @Override
    public final Object remover(ErroListaWrapper erro) {
        return desenfileirar(erro);
    }
}

class FilaEncadeada extends FilaAbstrata {
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

        if (vazia())
            first = node;
        else
            last.setNext(node);

        last = node;
        size++;
    }

    @Override
    public Object desenfileirar(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }

        Node aux = first;

        if (size == 1)
            last = null;

        first = first.getNext();
        size--;

        return aux.getItem();
    }

    @Override
    public Object getItem(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        return first.getItem();
    }

    @Override
    public Object[] toArray() {
        if (vazia())
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

class FilaArray extends FilaAbstrata {
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
    public Object desenfileirar(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        
        Object aux = items[0];

        size--;
        
        for (int i  = 0; i < size; i++) 
            items[i] = items[i + 1];

        return aux;
    }

    @Override
    public Object getItem(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        return items[0];
    }

    @Override
    public Object[] toArray() {
        if (vazia())
            return null;
        return Arrays.copyOf(items, size);
    }
}

abstract class ListaAbstrata extends AbstractList {
    public abstract void adicionarFim(Object item);

    public abstract void adicionarInicio(Object item);

    public abstract void adicionar(Object valor, int posicao, ErroListaWrapper erro);

    public abstract Object removerInicio(ErroListaWrapper erro);

    public abstract Object removerFim(ErroListaWrapper erro);

    public abstract Object remover(int posicao, ErroListaWrapper erro);

    public final Object getItem(ErroListaWrapper erro) {
        return getItem(0, erro);
    }

    public abstract Object getItem(int posicao, ErroListaWrapper erro);

    @Override
    public final void adicionar(Object item) {
        adicionarFim(item);
    }

    @Override
    public final Object remover(ErroListaWrapper erro) {
        return removerInicio(erro);
    }
}

class ListaEncadeada extends ListaAbstrata {
    private static class Node {
        private Object item;
        private Node next;

        public Node(Object item) {
            this(item, null);
        }

        public Node(Object item, Node next) {
            this.item = item;
            this.next = next;
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

    public ListaEncadeada() {
        first = last = null;
    }

    @Override
    public void adicionarFim(Object item) {
        Node node = new Node(item);

        if (vazia()) 
            first = node;
        else
            last.setNext(node);

        last = node;

        size++;
    }

    @Override
    public void adicionarInicio(Object item) {
        Node node = new Node(item, first);

        if (vazia())
            last = node;

        first = node;

        size++;
    }

    @Override
    public void adicionar(Object valor, int posicao, ErroListaWrapper erro) {
        if (posicao < 0 || posicao > size) {
            erro.setErro(ErroLista.INDICE_INVALIDO);

            return;
        }
        
        erro.setErro(ErroLista.SEM_ERRO);

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

        size++;
    }

    @Override
    public Object removerInicio(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);

            return null;
        }

        erro.setErro(ErroLista.SEM_ERRO);

        Node aux = first;

        if (size == 1)
            last = null;

        first = first.getNext();

        size--;

        return aux.getItem();
    }

    @Override
    public Object removerFim(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);

            return null;
        }

        erro.setErro(ErroLista.SEM_ERRO);

        Node aux = last;

        if (size == 1)
            first = last = null;
        else {
            Node prev = getNode(size - 2);

            prev.setNext(null);

            last = prev;
        }

        size--;

        return aux.getItem();
    }

    @Override
    public Object remover(int posicao, ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);

            return null;
        }
        else if (posicao < 0 || posicao >= size) {
            erro.setErro(ErroLista.INDICE_INVALIDO);

            return null;
        }

        if (posicao == 0)
            return removerInicio(erro);
        if (posicao == size - 1)
            return removerFim(erro);

        erro.setErro(ErroLista.SEM_ERRO);

        Node aux = getNode(posicao);
        Node prev = getNode(posicao - 1);

        prev.setNext(aux.getNext());

        size--;

        return aux.getItem();
    }

    private Node getNode(int index) {
        Node aux = first;

        for (int i = 0; i < index; i++)
            aux = aux.getNext();

        return aux;
    }

    @Override
    public Object getItem(int posicao, ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);

            return null;
        }
        else if (posicao < 0 || posicao >= size) {
            erro.setErro(ErroLista.INDICE_INVALIDO);

            return null;
        }

        erro.setErro(ErroLista.SEM_ERRO);

        return getNode(posicao).getItem();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        Node aux = first;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();
            aux = aux.getNext();
        }

        return array;
    }
}

class ListaArray extends ListaAbstrata {
    private static final int INITIAL_CAPACITY = 10;

    private Object[] items;

    public ListaArray() {
        items = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void adicionarFim(Object item) {
        if (size == items.length)
            items = Arrays.copyOf(items, items.length * 2);

        items[size] = item;
        size++;
    }

    @Override
    public void adicionarInicio(Object item) {
        if (size == items.length)
            items = Arrays.copyOf(items, items.length * 2);

        for (int i = size; i > 0; i--)
            items[i] = items[i - 1];

        items[0] = item;

        size++;
    }

    @Override
    public void adicionar(Object valor, int posicao, ErroListaWrapper erro) {
        if (posicao < 0 || posicao > size) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return;
        }
        
        erro.setErro(ErroLista.SEM_ERRO);

        if (posicao == 0) {
            adicionarInicio(valor);
            return;
        }
        if (posicao == size) {
            adicionarFim(valor);
            return;
        }

        if (size == items.length)
            items = Arrays.copyOf(items, items.length * 2);

        for (int i = size; i > posicao; i--)
            items[i] = items[i - 1];

        items[posicao] = valor;

        size++;
    }

    @Override
    public Object removerInicio(ErroListaWrapper erro) {
        return remover(0, erro);
    }

    @Override
    public Object removerFim(ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        return items[--size];
    }

    @Override
    public Object remover(int posicao, ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);

            return null;
        }
        else if (posicao < 0 || posicao >= size) {
            erro.setErro(ErroLista.INDICE_INVALIDO);

            return null;
        }

        if (posicao == size - 1)
            return removerFim(erro);

        erro.setErro(ErroLista.SEM_ERRO);

        Object aux = items[posicao];

        size--;

        for (int i = posicao; i < size; i++)
            items[i] = items[i + 1];

        return aux;
    }

    @Override
    public Object getItem(int posicao, ErroListaWrapper erro) {
        if (vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        else if (posicao < 0 || posicao >= size) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return null;
        }

        erro.setErro(ErroLista.SEM_ERRO);

        return items[posicao];
    }

    @Override
    public Object[] toArray() {
        if (vazia())
            return null;
        return Arrays.copyOf(items, size);
    }
}

class Main {

    private ILista lista;
    
    public Main(ILista lista) {
        this.lista = lista;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Object valor;
        ErroListaWrapper erro = new ErroListaWrapper();
        
        token = in.next();
        
        switch (token) {
            case "PE": main = new Main(new PilhaEncadeada()); break;
            case "PA": main = new Main(new PilhaArray()); break;
            case "FE": main = new Main(new FilaEncadeada()); break;
            case "FA": main = new Main(new FilaArray()); break;
            case "LE": main = new Main(new ListaEncadeada()); break;
            default: main = new Main(new ListaArray());
        }
        
        while (!token.equals("Q")) {
            erro.setErro(ErroLista.SEM_ERRO);
            switch(token) {
                case "A":   // adiciona um item
                    valor = in.nextInt();
                    main.lista.adicionar(valor);
                    break;      
                case "R":   // remove um item
                    main.lista.remover(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "G":   // retorna um item, sem remover
                    valor = main.lista.getItem(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    else
                        System.out.println(valor);
                    break;
                case "T":   // numero de itens na estrutura
                    System.out.println(main.lista.tamanho());
                    break;
                case "V":   // indica se a estrutura esta vazia
                    System.out.println(main.lista.vazia());
                    break;
                case "P":   // imprime os itens da estrutura, sem remover
                    Object valores[] = main.lista.toArray();
                    if (valores != null) {
                        for(Object item : valores)
                            System.out.println(item);
                    }
                    break;
            }
            token = in.next();
        }   
    }
}
