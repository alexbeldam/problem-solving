#include <stdio.h>

int main()
{
    for (int n, smt; 1 == scanf("%d", &n);)
    {
        if (n == 0)
            break;

        int sqr[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                smt = i + 1;

                if (j + 1 < smt)
                    smt = j + 1;
                if (n - i < smt)
                    smt = n - i;
                if (n - j < smt)
                    smt = n - j;

                sqr[i][j] = smt;
            }

        for (int i = 0, j; i < n; i++)
        {
            for (j = 0; j < n - 1; j++)
                printf("%3d ", sqr[i][j]);
            printf("%3d\n", sqr[i][j]);
        }
        printf("\n");
    }

    return 0;
}