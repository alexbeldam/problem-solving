import java.util.Scanner;

/**Classe que representa um <code>Nó</code> da <code>Pilha</code>*/
class Node {

    /**O <code>item</code> que esse <code>Nó</code> mantém*/
    private final Integer item;

    /**Referencia ao <code>Nó</code> antecedente a esse*/
    private final Node previous;

    /**
     * Construtor para inicializar um <code>Nó</code> com o <code>item</code> 
     * e <code>Nó</code> anterior indicados
     * 
     * @param item o <code>item</code> que esse No deve manter
     * @param previous a referencia ao No anterior a esse
     */
    public Node(Integer item, Node previous) {
        this.item = item;
        this.previous = previous;
    }

    /**
     * Recupera o <code>item</code> mantido nesse <code>Nó</code>.
     * 
     * @return <code>item</code> que esse <code>Nó</code> mantém.
     */
    public Integer getItem() {
        return item;
    }

    /**
     * Recupera a referencia ao <code>Nó</code> anterior que o <code>Nó</code> atual mantem.
     * 
     * @return a referencia ao <code>Nó</code> anterior que o <code>Nó</code> atual mantem 
     * ou <code>null</code> se não houver anterior.
     */
    public Node getPrevious() {
        return previous;
    }
}

/**Classe que representa uma <code>Pilha</code> de inteiros*/
class Pilha {

    /**O topo da <code>Pilha</code>*/
    private Node top;

    /**O número de elementos na <code>Pilha</code>*/
    private int size;

    /**
     * Construtor para inicializar um <code>Pilha</code> vazia.
     */
    public Pilha() {
        top = null;
        size = 0;
    }
    
    /**
     * Adiciona <code>item</code> no final da <code>Pilha</code>.
     */
    public void empilhar(Integer item) {
        Node node = new Node(item, top);

        top = node;

        size++;
    }
    
    /**
     * Remove um <code>item</code> no topo da <code>Pilha</code>.
     * return <code>item</code> no topo da <code>Pilha</code> ou 
     * <code>null</code> se a <code>Pilha</code> estiver vazia.
    */
    public Integer desempilhar() {
        if (vazia())
            return null;

        Node node = top;

        top = node.getPrevious();
        size--;

        return node.getItem();
    }
    
    /**
     * Recupera <code>item</code> no topo da <code>Pilha</code>, sem remover.
     * @return <code>item</code> no topo da <code>Pilha</code> ou 
     * <code>null</code> se a <code>Pilha</code> estiver vazia.
     */
    public Integer getItem() {
        if (vazia())
            return null;

        return top.getItem();
    }
    
    /**
     * Recupera número de itens na <code>Pilha</code>.
     * @return Número de itens mantidos na <code>Pilha</code>.
     */
    public int tamanho() {
        return size;
    }
    
    /**
     * Retorna <code>true</code> se a <code>Pilha</code> não possuir qualquer <code>item</code>.
     * @return <code>true</code> se a <code>Pilha</code> não possuir qualquer <code>item</code>, 
     * ou <code>false</code> se possuir.
     */
    public boolean vazia() {
        return tamanho() == 0;
    }
    
    /**
     * Retorna um array contendo todos os itens da <code>Pilha</code>.
     * @return um array com todos os elementos da <code>Pilha</code> 
     * <code>null</code> se a <code>Pilha</code> estiver vazia.
     */
    public Integer[] toArray() {
        if (vazia())
            return null;

        Integer[] array = new Integer[size];

        Node node = top;

        for (int i = 0; i < array.length; i++) {
            array[i] = node.getItem();

            node = node.getPrevious();
        }

        return array;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pilha pilha = new Pilha();
        String token;
        Integer valor;
        
        token = in.next();
        while (!token.equals("Q")) {
            switch(token) {
                case "E":
                    valor = in.nextInt();
                    pilha.empilhar(valor);
                    break;
                case "D":
                    valor = pilha.desempilhar();
                    if (valor == null)
                        System.out.println("NenhumItemException");
                    break;
                case "G":
                    valor = pilha.getItem();
                    if (valor != null)
                        System.out.println(valor);
                    else
                        System.out.println("NenhumItemException");
                    break;
                case "T":
                    System.out.println(pilha.tamanho());
                    break;
                case "V":
                    System.out.println(pilha.vazia());
                    break;
                case "P":
                    Integer valores[] = pilha.toArray();
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