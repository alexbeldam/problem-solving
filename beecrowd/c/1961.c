#include <stdio.h>

int main()
{
    int p, n, c1, c2;

    scanf("%d %d", &p, &n);
    scanf("%d", &c1);

    while (--n)
    {
        scanf("%d", &c2);

        if (c2 - c1 > p || c1 - c2 > p)
        {
            printf("GAME OVER\n");

            return 0;
        }

        c1 = c2;
    }

    printf("YOU WIN\n");

    return 0;
}