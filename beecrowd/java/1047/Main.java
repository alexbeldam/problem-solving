import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int timeInMinutes = 0;
        Scanner scanner = new Scanner(System.in);
        
        timeInMinutes -= scanner.nextInt() * 60;
        timeInMinutes -= scanner.nextInt();
        timeInMinutes += scanner.nextInt() * 60;
        timeInMinutes += scanner.nextInt();
        timeInMinutes--;
        timeInMinutes += 1440;
        timeInMinutes %= 1440;
        timeInMinutes++;
        
        System.out.println("O JOGO DUROU " + timeInMinutes / 60 + " HORA(S) E " + timeInMinutes % 60 + " MINUTO(S)");

        scanner.close();
    }
}