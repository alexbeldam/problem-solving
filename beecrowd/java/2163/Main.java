import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rows, columns, x, y, matrix[][];

        Scanner scanner = new Scanner(System.in);

        x = y = 0;

        rows = scanner.nextInt();
        columns = scanner.nextInt();

        matrix = new int[++rows][++columns];

        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[i].length; j++)
                matrix[i][j] = scanner.nextInt();

        for (int i = 2; i < matrix.length - 1 && x == 0; i++)
            for (int j = 2; j < matrix[i].length - 1; j++)
                if (matrix[i][j] == 42 && matrix[i-1][j-1] == 7 && matrix[i-1][j] == 7 && 
                    matrix[i-1][j+1] == 7 && matrix[i][j-1] == 7 && matrix[i+1][j-1] == 7 && 
                    matrix[i][j+1] == 7 && matrix[i+1][j+1] == 7 && matrix[i+1][j] == 7) {
                    x = i;
                    y = j;

                    break;
                }


        System.out.println(x + " " + y);

        scanner.close();
    }
}