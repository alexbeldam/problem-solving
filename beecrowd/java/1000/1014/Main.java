import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int km;
        double l;
        Scanner scanner = new Scanner(System.in);
        
        km = scanner.nextInt();
        l = scanner.nextDouble();
        
        System.out.printf("%.3f km/l\n", km / l);

        scanner.close();
    }
}