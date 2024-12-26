#include <stdio.h>

int main()
{
    int t, x, n = 5, num = 0;

    scanf("%d", &t);

    while (n--)
    {
        scanf("%d", &x);

        num += (x == t);
    }

    printf("%d\n", num);

    return 0;
}
