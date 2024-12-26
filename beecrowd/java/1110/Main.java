import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n;

        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            ArrayList<Integer> cartas = new ArrayList<>(n);

            for (int i = 1; i <= n; i++)
                cartas.add(i);

            ArrayList<Integer> discartadas = new ArrayList<>(n - 1);

            while(n-- > 1) {
                discartadas.add(cartas.remove(0));
                cartas.add(cartas.remove(0));
            }

            StringBuilder sb = new StringBuilder("Discarded cards:");

            for (int carta : discartadas)
                sb.append(' ')
                  .append(carta)
                  .append(',');

            sb.deleteCharAt(sb.length() - 1)
              .append('\n')
              .append("Remaining card: ")
              .append(cartas.get(0));

            System.out.println(sb);
        }
    }
}