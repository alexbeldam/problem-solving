#include <stdio.h>

int main()
{
    unsigned long long input;

    scanf("%llu", &input);

    while (input != 0)
    {
        printf("%llu", input % 10);

        input /= 10;
    }

    printf("\n");

    return 0;
}