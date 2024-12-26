import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> lista = new LinkedList<>();
        String token;
        Integer valor;
        int posicao;
        
        token = in.next();
        while (!token.equals("Q")) {
            try {
                switch(token) {
                    case "AF":
                        valor = in.nextInt();
                        lista.add(valor);
                        break;
                    case "AI":
                        valor = in.nextInt();
                        lista.addFirst(valor);
                        break;                    
                    case "AP":
                        posicao = in.nextInt();
                        valor = in.nextInt();
                        lista.add(posicao, valor);
                        break;          
                    case "RI":
                        lista.remove();
                        break;
                    case "RF":
                        lista.removeLast();
                        break;
                    case "RP":                    
                        posicao = in.nextInt();
                        lista.remove(posicao);
                        break;
                    case "G":
                        valor = lista.getFirst();
                        System.out.println(valor);
                        break;
                    case "GP":
                        posicao = in.nextInt();
                        valor = lista.get(posicao);
                        System.out.println(valor);
                        break;
                    case "T":
                        System.out.println(lista.size());
                        break;
                    case "V":
                        System.out.println(lista.isEmpty());
                        break;
                    case "P":
                        int size = lista.size();

                        if (size == 0)
                            break;

                        Integer valores[] = new Integer[size];

                        lista.toArray(valores);

                        for (Integer item : valores)
                            System.out.println(item);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("PosicaoInvalidaException");
            } catch (NoSuchElementException e) {
                System.out.println("NenhumItemException");
            }

            token = in.next();
        }   
    }
}
