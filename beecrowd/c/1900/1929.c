#include <stdio.h>

void bubble(int *a, int *b, int *c) {
    int order[] = {*a, *b, *c}, aux;

    for (int i = 0; i < 3; i++)
        for (int j = 1; j < 3 - i; j++)
            if (order[j - 1] < order[j])
            {
                aux = order[j - 1];
                order[j - 1] = order[j];
                order[j] = aux;
            }

    *a = order[0];
    *b = order[1];
    *c = order[2];
}

int is_triangle(int a, int b, int c) {
    bubble(&a, &b, &c);

    return b + c > a ? 1 : 0;
}

char can_triangle(int a, int b, int c, int d) {
    if (is_triangle(a, b, c))
        return 'S';
    if (is_triangle(a, b, d))
        return 'S';
    if (is_triangle(a, c, d))
        return 'S';
    if (is_triangle(b, c, d))
        return 'S';
    return 'N';
}

int main() {
    int a, b, c, d;

    scanf("%d %d %d %d", &a, &b, &c, &d);
    printf("%c\n", can_triangle(a, b, c, d));

    return 0;
}