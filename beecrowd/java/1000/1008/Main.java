import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number, hours;
        double value;
        Scanner scanner = new Scanner(System.in);
        
        number = scanner.nextInt();
        
        System.out.println("NUMBER = " + number);
        
        hours = scanner.nextInt();
        value = scanner.nextDouble();
        
        System.out.printf("SALARY = U$ %.2f\n", hours * value);

        scanner.close();
    }
}