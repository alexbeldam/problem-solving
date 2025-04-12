#include <stdio.h>
#include <string.h>

int main()
{
    int n;
    
    scanf("%d", &n);
    
    while (n--)
        scanf(" %*[^\n]");

    printf("Ciencia da Computacao\n");

    return 0;
}