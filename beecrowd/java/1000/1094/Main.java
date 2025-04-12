import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char animal;
        int rats, bunnies, frogs, animalsNum, newAnimals, sum;
        Scanner scanner = new Scanner(System.in);

        rats = bunnies = frogs = 0;

        animalsNum = scanner.nextInt();

        while (animalsNum-- > 0) {
            newAnimals = scanner.nextInt();
            animal = scanner.next().charAt(0);

            switch(animal) {
                case 'R':
                rats += newAnimals;
                break;
                case 'C':
                bunnies += newAnimals;
                break;
                default:
                frogs += newAnimals;
            }
        }

        sum = rats + bunnies + frogs;

        System.out.println("Total: " + sum + " cobaias");
        System.out.println("Total de coelhos: " + bunnies);
        System.out.println("Total de ratos: " + rats);
        System.out.println("Total de sapos: " + frogs);
        System.out.printf("Percentual de coelhos: %.2f %%\n", bunnies * 100.0 / sum);
        System.out.printf("Percentual de ratos: %.2f %%\n", rats * 100.0 / sum);
        System.out.printf("Percentual de sapos: %.2f %%\n", frogs * 100.0 / sum);

        scanner.close();
    }
}