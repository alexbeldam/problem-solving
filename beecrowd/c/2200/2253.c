#include <stdio.h>
#include <string.h>

int main()
{
    char str[50];
    int lwcs, upcs, num;

    while (scanf(" %[^\n]s", str) != EOF)
    {
        if (6 <= strlen(str) && strlen(str) <= 32)
        {
            for (int i = lwcs = upcs = num = 0; i < strlen(str); i++)
            {
                if ('A' <= str[i] && str[i] <= 'Z')
                    upcs = 1;
                else if ('a' <= str[i] && str[i] <= 'z')
                    lwcs = 1;
                else if ('0' <= str[i] && str[i] <= '9')
                    num = 1;
                else
                {
                    lwcs = 0;
                    break;
                }
            }

            if (!lwcs || !upcs || !num)
                puts("Senha invalida.");
            else
                puts("Senha valida.");
        }
        else
            puts("Senha invalida.");
    }

    return 0;
}