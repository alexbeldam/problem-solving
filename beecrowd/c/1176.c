#include <stdio.h>

int main()
{
    int n, x;
    long long fib[61] = {0, 1};

    for (int i = 2; i < 61; i++)
        fib[i] = fib[i - 1] + fib[i - 2];

    scanf("%d", &n);

    while (n--)
    {
        scanf("%d", &x);

        printf("Fib(%d) = %lld\n", x, fib[x]);
    }

    return 0;
}
