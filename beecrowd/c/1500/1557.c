#include <stdio.h>
#include <stdlib.h>

typedef int array_type;
typedef array_type * array;
typedef array * matriz;

void preenche_matriz(matriz array, int size) {
    int el = 1;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            array[i][j] = el;
            el *= 2;
        }

        el = array[i][0] * 2;
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
    int digits = 0, bgst = array[size - 1][size - 1];

    while (bgst > 0) {
        bgst /= 10;
        digits++;
    }

    for (int i = 0, j; i < size; i++) {
        for (j = 0; j < size - 1; j++)
            printf("%*d ", digits, array[i][j]);
        printf("%*d\n", digits, array[i][j]);
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