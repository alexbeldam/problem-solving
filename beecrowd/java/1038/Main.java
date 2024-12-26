import java.util.Scanner;

class Lanche {
    private double price;

    public Lanche(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Lanchonete {
    private Lanche[] lanches;

    public Lanchonete(int size) {
        lanches = new Lanche[size + 1];

        for (int i = 1; i <= size; i++)
            lanches[i] = new Lanche(0); 
    }

    public Lanche getLanche(int pos) {
        if (pos <= 0 || pos >= lanches.length)
            return null;
        return lanches[pos];
    }

    public void setLanche(int pos, double price) {
        if (pos > 0 && pos < lanches.length)
            lanches[pos].setPrice(price);
    }
}

class Pedido {
    private double total;

    public Pedido(Lanchonete lanchonete, int code, int quantity) {
        double price = lanchonete.getLanche(code).getPrice();

        total = price * quantity;
    }

    public double getTotal() {
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lanchonete lanchonete = new Lanchonete(5);

        lanchonete.setLanche(1, 4);
        lanchonete.setLanche(2, 4.5);
        lanchonete.setLanche(3, 5);
        lanchonete.setLanche(4, 2);
        lanchonete.setLanche(5, 1.5);

        Pedido pedido = new Pedido(lanchonete, scanner.nextInt(), scanner.nextInt());

        System.out.printf("Total: R$ %.2f\n", pedido.getTotal());

        scanner.close();
    }
}