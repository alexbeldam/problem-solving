import java.util.Scanner;

class Figura {
    protected double mainDimension;

    protected Figura(double lado) {
        mainDimension = lado;
    }

    public double getArea() {
        return mainDimension;
    }
}

class Circulo extends Figura {
    private static final double PI = 3.14159;

    public Circulo(double raio)  {
        super(raio);
    }

    @Override
    public double getArea() {
        return PI * mainDimension * mainDimension;
    }
}

class Triangulo extends Figura {
    private double base;

    public Triangulo(double base, double altura) {
        super(altura);

        this.base = base;
    }

    @Override
    public double getArea() {
        return base * mainDimension / 2;
    }
}

class Trapezio extends Figura {
    private double base0;
    private double base1;

    public Trapezio(double base0, double base1, double altura) {
        super(altura);

        this.base0 = base0;
        this.base1 = base1;
    }

    @Override
    public double getArea() {
        return (base0 + base1) * mainDimension / 2;
    }
}

class Retangulo extends Trapezio {
    public Retangulo(double base, double altura) {
        super(base, base, altura);
    }
}

class Quadrado extends Retangulo {
    public Quadrado(double lado) {
        super(lado, lado);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Figura figura;

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        figura = new Triangulo(a, c);

        System.out.printf("TRIANGULO: %.3f\n", figura.getArea());

        figura = new Circulo(c);

        System.out.printf("CIRCULO: %.3f\n", figura.getArea());

        figura = new Trapezio(a, b, c);

        System.out.printf("TRAPEZIO: %.3f\n", figura.getArea());

        figura = new Quadrado(b);

        System.out.printf("QUADRADO: %.3f\n", figura.getArea());

        figura = new Retangulo(a, b);

        System.out.printf("RETANGULO: %.3f\n", figura.getArea());

        scanner.close();
    }
}