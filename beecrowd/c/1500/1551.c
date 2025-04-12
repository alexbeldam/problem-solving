#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int n, cont;
    char **string, letter[27];

    scanf("%d", &n);

    string = malloc(n * sizeof(char *));

    for (int i = 0; i < n; i++) 
    {
        string[i] = malloc(1001);
        strcpy(letter, "abcdefghijklmnopqrstuvwxyz");

        scanf(" %[^\n]s", string[i]);

        for (int j = cont = 0; j < strlen(string[i]); j++)
            for (int k = 0; k < 26; k++)
                if (string[i][j] == letter[k]) 
                {
                    letter[k] = 1;
                    cont++;

                    break; 
                }

        if (cont == 26)
            puts("frase completa");
        else if (cont >= 13)
            puts("frase quase completa");
        else
            puts("frase mal elaborada");

        free(string[i]);
    }

    free(string);

    return 0;
}