import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int code, alcohol, gas, diesel;
        Scanner scanner = new Scanner(System.in);

        gas = alcohol = diesel = 0;

        do {
            code = scanner.nextInt();

            switch(code) {
                case 1:
                alcohol++;
                break;
                case 2:
                gas++;
                break;
                case 3:
                diesel++;
            }
        } while(code != 4);

        System.out.println("MUITO OBRIGADO");
        System.out.println("Alcool: " + alcohol);
        System.out.println("Gasolina: " + gas);
        System.out.println("Diesel: " + diesel);

        scanner.close();
    }
}