#include <stdio.h>

int main()
{
    int x, odd;

    scanf("%d", &x);

    for (odd = 1; odd <= x; odd += 2)
        printf("%d\n", odd);

    return 0;
}
