#include <stdio.h>
#include <string.h>

int main()
{
    char word[101];

    while (scanf(" %[^\n]", word) != EOF)
    {
        for (int i = 0, aux = strlen(word); i < strlen(word); i++)
        {
            for (int j = 0; j < i; j++)
                printf(" ");

            for (int k = 0; k < aux; k++)
            {
                if (k != 0)
                    printf(" ");

                printf("%c", word[k]);
            }

            printf("\n");

            aux--;
        }

        printf("\n");
    }

    return 0;
}