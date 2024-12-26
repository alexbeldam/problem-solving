#include <stdio.h>
#include <stdlib.h>

int quantos_numeros(int num)
{
    int sum = 1;

    for (int i = 1; i <= num; i++)
        sum += i;

    return sum;
}

int *cria_sequencia(int size)
{
    int *array = malloc(size * sizeof(int)), n = 1, i = 1;

    array[0] = 0;

    while (i < size)
    {
        for (int j = 0; j < n; i++, j++)
            array[i] = n;

        n++;
    }

    return array;
} 

void putarray(int *array, int size)
{
    int i;

    for (i = 0; i < size - 1; i++)
        printf("%d ", array[i]);
    printf("%d\n\n", array[i]);
}

int main()
{
    int *sequencia, n, cont = 1;

    while (scanf("%d", &n) != EOF)
    {
        n = quantos_numeros(n);

        sequencia = cria_sequencia(n);


        if (n == 1)
            printf("Caso %d: 1 numero\n", cont);
        else
            printf("Caso %d: %d numeros\n", cont, n);
        putarray(sequencia, n);

        cont++;
    }

    return 0;
}