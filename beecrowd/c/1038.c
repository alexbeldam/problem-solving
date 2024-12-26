#include <stdio.h>

int main()
{
    int code;
    double quan, price[6] = {0, 4, 4.5, 5, 2, 1.5};

    scanf("%d %lf", &code, &quan);

    price[0] = price[code] * quan;

    printf("Total: R$ %.2f\n", price[0]);

    return 0;
}