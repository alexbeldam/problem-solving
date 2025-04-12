import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, code, times;
        double price, total = 0;
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        while(n-- > 0) {
            code = scanner.nextInt();
            times = scanner.nextInt();

            switch(code) {
                case 1001:
                price = 1.5;
                break;
                case 1002:
                price = 2.5;
                break;
                case 1003:
                price = 3.5;
                break;
                case 1004:
                price = 4.5;
                break;
                default:
                price = 5.5;
            }

            total += price * times;
        }

        System.out.printf("%.2f\n", total);

        scanner.close();
    }
}