#include <stdio.h>

int main()
{
    int n, a[70][70];

    while (scanf("%d", &n) != EOF)
    {
        for (int i = 0, d = n - 1; i <= n; i++, d--)
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                    a[i][j] = 1;
                else
                    a[i][j] = 3;
                if (j == d)
                    a[i][d] = 2;
            }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - 1; j++)
                printf("%d", a[i][j]);
            printf("%d\n", a[i][n - 1]);
        }
    }

    return 0;
}
