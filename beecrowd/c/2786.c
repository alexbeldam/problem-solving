#include <stdio.h>

int main()
{
    int l, c, t[2];

    scanf("%d %d", &l, &c);

    t[0] = l * c + (l - 1) * (c - 1);
    t[1] = 2 * (l - 1) + 2 * (c - 1);

    for (int i = 0; i < 2; i++)
        printf("%d\n", t[i]);

    return 0;
}
