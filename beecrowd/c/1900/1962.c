#include <stdio.h>

int main()
{
    int n, t;

    scanf("%d", &n);

    while (n--)
    {
        scanf("%d", &t);

        if (2014 - t < 0)
            printf("%d A.C.\n", t - 2014);
        else
            printf("%d D.C.\n", 2015 - t);
    }

    return 0;
}