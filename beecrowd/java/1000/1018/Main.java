import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);
        
        x = scanner.nextInt();
        
        System.out.println(x);
        
        for (int i = 100; i > 0; i /= 2) {
            if (i == 25)
                i = 20;
            
            System.out.println(x / i + " nota(s) de R$ " + i + ",00");
            
            x %= i;
        }

        scanner.close();
    }
}