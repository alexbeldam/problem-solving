#include <stdio.h>

int main()
{
    int n, mark[100][100], leo[100][100], card[2], atribute;

    while (scanf("%d", &n) != EOF)
    {
        scanf("%d %d", &card[0], &card[1]);

        for (int i = 1; i <= card[0]; i++)
            for (int j = 1; j <= n; j++)
                scanf("%d", &mark[i][j]);
        for (int i = 1; i <= card[1]; i++)
            for (int j = 1; j <= n; j++)
                scanf("%d", &leo[i][j]);

        scanf("%d %d", &card[0], &card[1]);
        scanf("%d", &atribute);

        if (mark[card[0]][atribute] > leo[card[1]][atribute])
            printf("Marcos\n");
        else if (mark[card[0]][atribute] == leo[card[1]][atribute])
            printf("Empate\n");
        else
            printf("Leonardo\n");
    }

    return 0;
}