#include <stdio.h>
#include <stdlib.h>

typedef int array_type;
typedef array_type * array;
typedef array * matriz;

void preenche_matriz(matriz array, int size) {
    for (int i = 0, j; i < size; i++)
        for (j = 0; j < size; j++)
        {
            if (i == j)
                array[i][j] = 1;
            else if (i < j)
                array[i][j] = j - i + 1;
            else
                array[i][j] = i - j + 1;    
        }
}

matriz cria_matriz(int size) {
    matriz nova = (matriz) malloc (size * sizeof(array *));

    for (int i = 0; i < size; i++)
        nova[i] = (array) malloc (size * sizeof(array_type));

    preenche_matriz(nova, size);

    return nova;
}

void destroi_matriz(matriz array, int size) {
    for (int i = 0; i < size; i++)
        free(array[i]);
    free(array);
}

void imprime_matriz(matriz array, int size) {
    for (int i = 0, j; i < size; i++) {
        for (j = 0; j < size - 1; j++)
            printf("%3d ", array[i][j]);
        printf("%3d\n", array[i][j]);
    }

    destroi_matriz(array, size);
}

int main() {
    int n;
    matriz array;

    while (1) {
        scanf("%d", &n);

        if (n == 0)
            break;

        array = cria_matriz(n);

        imprime_matriz(array, n);
        puts("");
    }

    return 0;
}