#include <stdio.h>

int main()
{
    unsigned n;

    scanf("%u", &n);

    for (int x, y; n--;)
    {
        scanf("%d %d", &x, &y);

        if ((x - 1) % 2 != 0)
            x += 1;

        int sum = 0;

        for (int i = 0; i < y; x += 2, i++)
            sum += x;

        printf("%d\n", sum);
    }

    return 0;
}
