#include <stdio.h>
#include <string.h>

int main() 
{
    char sentence[150], *aux;
    int n;

    scanf("%d", &n);

    while (n--)
    {
        scanf(" %[^\n]", sentence);

        aux = strstr(sentence, "oulupukk");

        while (aux != NULL)
        {
            *(aux - 1) = 'J';
            aux[8] = 'i';

                aux = strstr(aux + 10, "oulupukk");
        }

        puts(sentence);
    }

    return 0;
}