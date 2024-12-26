#include <stdio.h>
 
int main() 
{ 
    int x;

    scanf("%d", &x);

    printf("%d\n", x);
    printf("%d nota(s) de R$ 100,00\n", x / 100);
    x %= 100;
    printf("%d nota(s) de R$ 50,00\n", x / 50);
    x %= 50;
    printf("%d nota(s) de R$ 20,00\n", x / 20);
    x %= 20;
    printf("%d nota(s) de R$ 10,00\n", x / 10);
    x %= 10;
    printf("%d nota(s) de R$ 5,00\n", x / 5);
    x %= 5;
    printf("%d nota(s) de R$ 2,00\n", x / 2);
    printf("%d nota(s) de R$ 1,00\n", x % 2);

    return 0;
}
