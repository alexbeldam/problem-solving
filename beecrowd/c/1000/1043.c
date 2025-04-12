#include <stdio.h>
#include <stdlib.h>

int main()
{
    double a, b, c;

    scanf("%lf %lf %lf", &a, &b, &c);

    if ((a > abs(b - c) && a < b + c) || (b > abs(c - a) && b < c + a) || (c > abs(a - b) && c < a + b))
        printf("Perimetro = %.1lf", a + b + c);
    else
        printf("Area = %.1lf", ((a + b) * c) / 2);

    return 0;
}