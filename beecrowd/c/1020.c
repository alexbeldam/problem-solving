#include <stdio.h>

int main() 
{
    int age;

    scanf("%d", &age);

    printf("%d ano(s)\n", age / 365);
    printf ("%d mes(es)\n", age % 365 / 30);
    printf("%d dia(s)\n", age % 365 % 30);

    return 0;
}
