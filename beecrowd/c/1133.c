#include <stdio.h>

int main()
{
    int x, y, r;

    scanf("%d %d", &x, &y);

    if (y > x)
        for (r = x + 1; r < y; r++) {
            if (r % 5 == 2 || r % 5 == 3)
                printf("%d\n", r);
        }
    else
        for (r = y + 1; r < x; r++) {
            if (r % 5 == 2 || r % 5 == 3)
                printf("%d\n", r);
        }

    return 0;
}