#include <stdio.h>

int main()
{
    int col = 0;
    char c;

    while (scanf("%c", &c) != EOF)
    {
        if (c != '\n')
            col = col * 26 + c - 64;
        else
        {
            if (col <= 16384 && col > 0)
                printf("%d\n", col);
            else
                printf("Essa coluna nao existe Tobias!\n");
            col = 0;
        }
    }

    return 0;
}