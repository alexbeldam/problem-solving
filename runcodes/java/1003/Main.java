import java.util.Scanner;

/**
 * Classe que representa um {@code Nó} da {@code Fila}.
 * */
class Node {

    /**O {@code item} que esse {@code Nó} mantém*/
    private final Integer item;

    /**Referencia ao {@code Nó} procedente a esse*/
    private Node next;

    /**
     * Construtor para criar um {@code Nó}, sem procedente, que guarda o
     * {@code item} designado  
     * 
     * @param item o item que este {@code Nó} deve manter
     */
    public Node(Integer item) {
        this.item = item;

        next = null;
    }

    /**
     * @return o {@code item} que este {@code Nó} mantém
     */
    public Integer getItem() {
        return item;
    }

    /**
     * @return a referencia ao {@code Nó} próximo ao atual ou {@code null} se não houver próximo.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Altera a referencia do próximo {@code Nó} para o indicado
     * 
     * @param next o próximo {@code Nó}
     */
    public void setNext(Node next) {
        this.next = next;
    }
}

/**
 * Classe que representa uma {@code Fila} de inteiros.
 */
class Fila {

    /**O primeiro {@code Nó} da {@code Fila}*/
    private Node first;

    /**O último {@code Nó} da {@code Fila}*/
    private Node last;

    /**O número de elementos na {@code Fila}*/
    private int size;

    /** 
     * Construtor para inicializar uma {@code Fila} vazia
    */
    public Fila() {
        first = last = null;

        size = 0;
    }
    
    /**
     * Adiciona {@code item} no final da {@code Fila}.
     */
    void enfileirar(Integer item) {
        Node no = new Node(item);

        if (estaVazia()) 
            first = no;
        else
            last.setNext(no);

        last = no;

        size++;
    }
    
    /**
     * Remove um {@code item} no início da {@code Fila}.
     * return {@code item} no início da {@code Fila} ou {@code null} se a {@code Fila} estiver vazia.
    */
    Integer desenfileirar() {
        if (estaVazia())
            return null;

        Node aux = first;

        if (size == 1)
            last = null;

        first = first.getNext();

        size--;

        return aux.getItem();
    }
    
    /**
     * Recupera {@code item} no início da {@code Fila}, sem remover.
     * @return {@code item} no início da {@code Fila} ou {@code null} se a {@code Fila} estiver vazia.
     */
    Integer getItem() {
        if (estaVazia())
            return null;

        return first.getItem();
    }
    
    /**
     * Recupera número de itens na {@code Fila}.
     * @return Número de itens mantidos na {@code Fila}.
     */
    int tamanho() {
        return size;
    }
    
    /**
     * Retorna {@code true} se a {@code Fila} não possuir qualquer {@code item}.
     * @return {@code true} se a {@code Fila} não possuir qualquer {@code item}, 
     * ou {@code false} se possuir.
     */
    boolean estaVazia() {
        return size == 0;
    }
    
    /**
     * Retorna um array contendo todos os elementos da {@code Fila}.
     * @return um array com todos os elementos da {@code Fila}, {@code null} se a {@code Fila} estiver vazia.
     */
    Integer[] toArray() {
        Integer[] array = new Integer[size];

        Node aux = first;

        for (int i = 0; i < size; i++) {
            array[i] = aux.getItem();

            aux = aux.getNext();
        }

        return array;
    }
}


class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fila fila = new Fila();
        String token;
        Integer valor;
        
        token = in.next();
        while (!token.equals("Q")) {
            switch(token) {
                case "AF":
                    valor = in.nextInt();
                    fila.enfileirar(valor);
                    break;
                case "RI":
                    valor = fila.desenfileirar();
                    if (valor == null)
                        System.out.println("NenhumItemException");
                    break;
                case "G":
                    valor = fila.getItem();
                    if (valor != null)
                        System.out.println(valor);
                    else
                        System.out.println("NenhumItemException");
                    break;
                case "T":
                    System.out.println(fila.tamanho());
                    break;
                case "V":
                    System.out.println(fila.estaVazia());
                    break;
                case "P":
                    Integer valores[] = fila.toArray();
                    if (valores != null) {
                        for(Integer item: valores)
                            System.out.println(item);
                    }
                    break;
            }
            token = in.next();
        }
        
    }
}