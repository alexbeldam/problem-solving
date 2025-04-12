#include <stdio.h>

int main()
{
    int n[50], x;

    scanf("%d", &x);

    for (int i = 0; i < x; i++)
        n[i] = i;

    for (int i = 0; i < 1000;) {
        for (int cont = 0; cont < x && i < 1000; cont++, i++)
            printf("N[%d] = %d\n", i, n[cont]); 
    }

    return 0;
}