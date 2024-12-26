#include <stdio.h>
#include <string.h>

char pptls(char *shel, char *raj)
{
    if (strncmp(shel, "te", 2) == 0)
    {
        if (strncmp(raj, "pa", 2) == 0 || strncmp(raj, "la", 2) == 0)
            return 'b';
        if (strncmp(raj, "Sp", 2) == 0 || strncmp(raj, "pe", 2) == 0)
            return 't';
        return 'd';
    }
    else if (strncmp(shel, "pa", 2) == 0)
    {
        if (strncmp(raj, "pe", 2) == 0 || strncmp(raj, "Sp", 2) == 0)
            return 'b';
        if (strncmp(raj, "te", 2) == 0 || strncmp(raj, "la", 2) == 0)
            return 't';
        return 'd';
    }
    else if (strncmp(shel, "pe", 2) == 0)
    {
        if (strncmp(raj, "la", 2) == 0 || strncmp(raj, "te", 2) == 0)
            return 'b';
        if (strncmp(raj, "pa", 2) == 0 || strncmp(raj, "Sp", 2) == 0)
            return 't';
        return 'd';
    }
    else if (strncmp(shel, "la", 2) == 0)
    {
        if (strncmp(raj, "Sp", 2) == 0 || strncmp(raj, "pa", 2) == 0)
            return 'b';
        if (strncmp(raj, "pe", 2) == 0 || strncmp(raj, "te", 2) == 0)
            return 't';
        return 'd';
    }
    if (strncmp(raj, "te", 2) == 0 || strncmp(raj, "pe", 2) == 0)
        return 'b';
    if (strncmp(raj, "la", 2) == 0 || strncmp(raj, "pa", 2) == 0)
        return 't';
    return 'd';
}

int main()
{
    int n, i = 1;
    char shel[10], raj[10];

    scanf("%d", &n);

    while (n--)
    {
        scanf(" %s %s", shel, raj);

        printf("Caso #%d: ", i);

        switch (pptls(shel, raj))
        {
        case 'b':
            puts("Bazinga!");
            break;
        case 't':
            puts("Raj trapaceou!");
            break;
        default:
            puts("De novo!");
        }

        i++;
    }

    return 0;
}