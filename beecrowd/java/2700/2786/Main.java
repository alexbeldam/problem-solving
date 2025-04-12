import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int width, length, type1, type2;
        Scanner scanner = new Scanner(System.in);

        width = scanner.nextInt();
        length = scanner.nextInt();

        type1 = width * length + (width - 1) * (length - 1);
        type2 = 2 * (width - 1) + 2 * (length - 1);

        System.out.println(type1);
        System.out.println(type2);

        scanner.close();
    }
}