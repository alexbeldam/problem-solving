#include <stdio.h>
#include <stdlib.h>

int **dinamic_array(int size)
{
    int **array = (int **) malloc(size * sizeof(int *));

    for (int i = 0; i < size; i++)
        array[i] = (int *) calloc(size, sizeof(int));

    return array;
}

void free_array(int **array, int size)
{
    for (int i = 0; i < size; i++)
        free(array[i]);

    free(array);
}

void sqr_array(int **array, int size)
{
    for (int i = 0; i < size; i++)
        array[i][i] = 2;

    for (int i = 0; i < size; i++)
        array[i][size - 1 - i] = 3;

    for (int i = size / 3; i < size - size / 3; i++)
        for (int j = size / 3; j < size - size / 3; j++)
            array[i][j] = 1;

    array[size / 2][size / 2] = 4;
}

void put_array(int **array, int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
            printf("%d", array[i][j]);
        printf("\n");
    }
    printf("\n");
}

int main()
{
    int **sqr, n;

    while (scanf("%d", &n) != EOF)
    {
        sqr = dinamic_array(n);
        sqr_array(sqr, n);
        put_array(sqr, n);
        free_array(sqr, n);
    }

    return 0;
}