#include <stdio.h>
 
int main() 
{ 
    int a, n = 0, aux;

    scanf("%d", &a);
    
    aux = a;

    while (n <= 0)
        scanf("%d", &n);

    for (int i = 1; i < n; i++)
        a += aux + i;

    printf("%d\n", a);
 
    return 0;
}
