import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int A, B;
        Scanner scanner = new Scanner(System.in);
        
        A = scanner.nextInt();
        B = scanner.nextInt();
            
        System.out.println("X = " + (A + B));

        scanner.close();
    }
}