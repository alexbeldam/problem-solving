#include <stdio.h>

int main()
{
    int n, r[3];

    scanf("%d", &n);

    while (n--)
    {
        scanf("%d %d", r + 1, r + 2);

        printf("%d\n", *(r + 1) + *(r + 2));
    }

    return 0;
}