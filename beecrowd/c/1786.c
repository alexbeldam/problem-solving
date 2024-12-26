#include <stdio.h>
#include <math.h>

int main()
{
    int cpf, a[9];

    while (scanf("%d", &cpf) != EOF)
    {
        int b[2] = {};
        
        for (int i = 0, j = pow(10, 9); i < 9; i++, cpf %= j)
        {
            j /= 10;
            a[i] = cpf / j;
        }

        for (int i = 0; i < 9; i++)
            b[0] += a[i] * (i + 1);

        for (int i = 0; i < 9; i++)
            b[1] += a[i] * (9 - i);

        for (int i = 0; i < 2; i++)
        {
            b[i] %= 11;

            if (b[i] == 10)
                b[i] = 0;
        }

        for (int i = 0; i < 6; i++) 
        {
            for (int j = 0; j < 2; j++, i++)
                printf("%d", a[i]);
            printf("%d.", a[i]);
        }

        for (int i = 6; i < 9; i++)
            printf("%d", a[i]);

        printf("-%d%d\n", b[0], b[1]);
    }

    return 0;
}
