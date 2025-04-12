#include <stdio.h>

int main()
{
    for (int b, n, i, debt[4]; scanf("%d %d", &b, &n);)
    {
        if (b == n && n == 0)
            break;

        int bank[b];

        for (i = 0; i < b; i++)
            scanf("%d", &bank[i]);

        while (n--)
        {
            for (i = 0; i < 3; i++)
                scanf("%d", &debt[i]);

            bank[debt[0] - 1] -= debt[2];
            bank[debt[1] - 1] += debt[2];
        }

        for (i = 0, debt[3] = 'S'; i < b; i++)
            if (bank[i] < 0)
            {
                debt[3] -= 5;
                break;
            }

        printf("%c\n", debt[3]);
    }

    return 0;
}
