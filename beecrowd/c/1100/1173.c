#include <stdio.h>

int main()
{
    int n[10], x, i;

    scanf("%d", &x);

    for (i = 1, n[0] = x; i < 10; i++)
        n[i] = n[i - 1] * 2;

    for (i = 0; i < 10; i++)
        printf("N[%d] = %d\n", i, n[i]);

    return 0;
}