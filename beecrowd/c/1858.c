#include <stdio.h>
#include <stdlib.h>

int menor (int *v, int size)
{
    int min = 0;

    for (int i = 1; i < size; i++)
    {
        scanf("%d", v + i);

        if (*(v + i) < *(v + min))
            min = i; 
    }

    free(v);

    return min;
}

int main()
{
    int n, *t;

    scanf("%d", &n);

    t = (int *) malloc(++n * sizeof(int));

    *t = 101;

    printf("%d\n", menor(t, n));

    return 0;
}