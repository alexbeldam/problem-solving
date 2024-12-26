import java.util.Scanner;

class Bota {
    private int size;
    private int leftShoes = 0;
    private int rightShoes = 0;

    public Bota(int size) {
        this.size = size;
    }

    private void addLeftShoe() {
        leftShoes++;
    }

    private void addRightShoe()  {
        rightShoes++;
    }

    public void addShoe(char shoe) {
        switch (shoe) {
            case 'E': 
                addLeftShoe();
                break;
            default:
                addRightShoe();
        }
    }

    public void clear() {
        rightShoes = leftShoes = 0;
    }

    public int getPairs() {
        return Math.min(leftShoes, rightShoes);
    }
}

class Inventario {
    private int MAX_SIZE = 60;
    private int MIN_SIZE = 30;

    private Bota[] botas;

    public Inventario() {
        botas = new Bota[MAX_SIZE + 1];
        
        for (int i = MIN_SIZE; i < botas.length; i++)
            botas[i] = new Bota(i);
    }

    public void addShoe(int size, char shoe) {
        botas[size].addShoe(shoe);
    }

    public void clear() {
        for (int i = MIN_SIZE; i < botas.length; i++)
            botas[i].clear();
    }

    public int getPairs() {
        int pairs = 0;

        for (int i = MIN_SIZE; i < botas.length; i++)
            pairs += botas[i].getPairs();
            
        return pairs;
    }
}

public class Main {
    public static void main(String[] args) {
        Inventario botas = new Inventario();

        Scanner scanner = new Scanner(System.in);

        int n;

        while(scanner.hasNext()) {
            n = scanner.nextInt();

            while (n-- > 0)
                botas.addShoe(scanner.nextInt(), scanner.next().charAt(0));

            System.out.println(botas.getPairs());

            botas.clear();
        }

        scanner.close();
    }
}