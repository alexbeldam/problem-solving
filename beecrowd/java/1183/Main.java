import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double matrix[][] = new double[12][12], sum = 0;
        char t;

        Scanner scanner = new Scanner(System.in);

        t = scanner.next().charAt(0);

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = scanner.nextDouble();

        for (int i = 0; i < matrix.length - 1; i++)
            for (int j = matrix.length - 1; j > i; j--)
                sum += matrix[i][j];

        if (t == 'M')
            sum /= 66;

        System.out.printf("%.1f\n", sum);

        scanner.close();
    }
}