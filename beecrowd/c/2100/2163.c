#include <stdio.h>

int main()
{
    unsigned n, k, y, x;
    int m[1001][1001];

    x = y = 0;

    scanf("%u %u", &n, &k);

    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= k; j++)
            scanf("%d", &m[i][j]);

    for (int i = 1; i <= n && x == 0; i++)
        for (int j = 1; j <= k; j++)
            if (m[i][j] == 42)
                if (m[i-1][j-1] == 7 && m[i-1][j] == 7 && m[i-1][j+1] == 7)
                    if (m[i][j-1] == 7 && m[i][j+1] == 7)
                        if (m[i+1][j-1] == 7 && m[i-1][j] == 7 && m[i+1][j+1] == 7)
                            {
                                x = i;
                                y = j;
                                break;
                            }

    printf("%u %u\n", x, y);

    return 0;
}