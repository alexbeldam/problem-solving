#include <stdio.h>

int main()
{
    int i;
    double x, sum;

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

    return 0;
}