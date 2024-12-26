#include <stdio.h>
#include <string.h>

int main()
{
    int cont;
    char input[1001];

    while (scanf(" %[^\n]", input) != EOF)
    {
        for (int i = cont = 0; i < strlen(input); i++)
        {
            if (input[i] == '(')
                cont++;
            else if (input[i] == ')')
            {
                cont--;
                if (cont < 0)
                    break;
            }
        }

        if (cont == 0)
            puts("correct");
        else
            puts("incorrect");
    }

    return 0;
}