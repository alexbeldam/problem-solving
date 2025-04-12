#include <stdio.h>

int main()
{
    int n, x, y;

    scanf("%d %d %d", &n, &x, &y);

    if (n >= x + y)
        printf("Farei hoje!\n");
    else 
        printf("Deixa para amanha!\n");

    return 0;
}
