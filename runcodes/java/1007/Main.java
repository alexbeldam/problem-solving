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

abstract class Lista {
    protected int size;

    public Lista() {
        size = 0;
    }

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

    public final int tamanho() {
        return size;
    }

    public final boolean vazia() {
        return size == 0;
    }

    public abstract Object[] toArray();
}

class ListaEncadeada extends Lista {
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

class ListaArray extends Lista {
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
    private Lista lista;
    
    public Main(Lista lista) {
        this.lista = lista;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Object valor;
        int posicao;
        ErroListaWrapper erro = new ErroListaWrapper();
        
        token = in.next();
        
        if (token.equals("LE"))
            main = new Main(new ListaEncadeada());
        else
            main = new Main(new ListaArray());
        
        while (!token.equals("Q")) {
            erro.setErro(ErroLista.SEM_ERRO);
            switch(token) {
                case "AF":
                    valor = in.nextInt();
                    main.lista.adicionarFim(valor);
                    break;
                case "AI":
                    valor = in.nextInt();
                    main.lista.adicionarInicio(valor);
                    break;                    
                case "AP":
                    posicao = in.nextInt();
                    valor = in.nextInt();
                    main.lista.adicionar(valor, posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;          
                case "RI":
                    main.lista.removerInicio(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "RF":
                    main.lista.removerFim(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "RP":                    
                    posicao = in.nextInt();
                    main.lista.remover(posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "G":
                    valor = main.lista.getItem(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    else
                        System.out.println(valor);
                    break;
                case "GP":
                    posicao = in.nextInt();
                    valor = main.lista.getItem(posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    else
                        System.out.println(valor);
                    break;
                case "T":
                    System.out.println(main.lista.tamanho());
                    break;
                case "V":
                    System.out.println(main.lista.vazia());
                    break;
                case "P":
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
