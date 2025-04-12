#include <stdio.h>
int main()
{
    int i;
    double x, sum;

    while (i < 2) {
        for (i = sum = 0; i < 2;)
        {
            scanf("%lf", &x);

            if (x >= 0 && x <= 10)
            {
                sum += x;
                i++;
            }
            else
                printf("nota invalida\n");
        }

        printf("media = %.2f\n", sum / 2);

        for (i = 0; i != 2 && i != 1;) {
            printf("novo calculo (1-sim 2-nao)\n");
            scanf("%d", &i);
        }
    }

    return 0;
}