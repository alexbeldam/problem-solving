import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(scanner.nextInt() * 2 + " minutos");

        scanner.close();
    }
}