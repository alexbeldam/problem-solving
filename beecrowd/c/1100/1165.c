#include <stdio.h>

int main() 
{
    int j;

    scanf("%d", &j);

    for (int sum, i, n; j--;)
    {
        scanf("%d", &n);

        for (i = 1, sum = 0; i <= n; i++)
            if (n % i == 0)
                sum += i;

        if (sum == n+1)
            printf("%d eh primo\n", n);
        else
            printf("%d nao eh primo\n", n);
    }

    return 0;
}