#include <stdio.h>
#include <string.h>

int main()
{
    char d[101], s[101];

    while (scanf(" %[^\n]", d) != EOF)
    {
        scanf(" %[^\n]", s);

        strstr(d, s) != NULL ? puts("Resistente") : puts("Nao resistente");
    }

    return 0;
}