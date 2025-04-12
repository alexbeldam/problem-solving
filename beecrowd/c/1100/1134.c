#include <stdio.h>

int main()
{
    int x, a, g, d;

    a = g = d = 0;

    do
    {
        scanf("%d", &x);

        switch (x)
        {
        case 1:
            a++;
            break;
        case 2:
            g++;
            break;
        case 3:
            d++;
        }
    } while (x != 4);

    printf("MUITO OBRIGADO\n");
    printf("Alcool: %d\n", a);
    printf("Gasolina: %d\n", g);
    printf("Diesel: %d\n", d);

    return 0;
}