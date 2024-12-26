import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        
        System.out.printf("MEDIA = %.1f\n", (a * 2 + b * 3 + c * 5) / 10);

        scanner.close();
    }
}