import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();
        String token;
        Integer valor;
        
        token = in.next();
        while (!token.equals("Q")) {
            try {
                switch(token) {
                    case "E":
                        valor = in.nextInt();
                        pilha.push(valor);
                        break;
                    case "D":
                        valor = pilha.pop();
                        break;
                    case "G":
                        valor = pilha.peek();
                        System.out.println(valor);
                        break;
                    case "T":
                        System.out.println(pilha.size());
                        break;
                    case "V":
                        System.out.println(pilha.empty());
                        break;
                    case "P":
                        int size = pilha.size();

                        if (size == 0)
                            break;

                        Integer[] array = new Integer[size];

                        pilha.toArray(array);

                        Integer[] valores = new Integer[size];

                        for (int i = 0; i < size; i++)
                            valores[i] = array[size - 1 - i];

                        for (Integer item : valores)
                            System.out.println(item);
                } 
            } catch (EmptyStackException e) {
                System.out.println("NenhumItemException");
            }

            token = in.next();
        }
    }
}