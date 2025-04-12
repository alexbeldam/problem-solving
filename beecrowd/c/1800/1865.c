#include <stdio.h>
#include <string.h>

int main()
{
    int n, force;
    char name[20];

    scanf("%d", &n);

    while (n--)
    {
        scanf(" %s %d", name, &force);

        if (strcmp(name, "Thor") == 0)
            printf("Y\n");
        else
            printf("N\n");
    }

    return 0;
}