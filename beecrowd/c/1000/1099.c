#include <stdio.h>

int main()
{
    int n, x, y, sum;

    scanf("%d", &n);

    while (n--)
    {
        scanf("%d %d", &x, &y);

        if (y > x)
        {
            sum = y;
            y = x;
            x = sum;
        }
        if (++y % 2 == 0)
            y++;

        for (sum = 0; x > y; y += 2)
            sum += y;

        printf("%d\n", sum);
    }

    return 0;
}