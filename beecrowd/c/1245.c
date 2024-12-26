#include <stdio.h>

int main()
{
    for (int n, pair; scanf("%d", &n) != EOF;)
    {
        int size[n], k[2] = {29, 61};
        char foot[n];

        for (int i = pair = 0; i < n; i++)
        {
            scanf("%d", &size[i]);
            scanf(" %c", &foot[i]);
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (size[i] == size[j] && foot[i] != foot[j])
                {
                    pair++;
                    size[j] = k[0];
                    size[i] = k[1];
                    k[1]++;
                    k[0]--;
                    break;
                }

        printf("%d\n", pair);
    }

    return 0;
}