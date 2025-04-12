#include <stdio.h>

int main()
{
    double x, y, z, a, b, c;

    scanf("%lf %lf %lf", &x, &y, &z);

    if (y <= x && x >= z)
    {
        a = x;
        b = y;
        c = z;
    }
    if (x <= y && y >= z)
    {
        a = y;
        b = z;
        c = x;
    }
    if (x <= z && z >= y)
    {
        a = z;
        b = x;
        c = y;
    }
    if (a < b + c)
    {
        if (a * a == b * b + c * c)
            printf("TRIANGULO RETANGULO\n");
        else if (a * a > b * b + c * c)
            printf("TRIANGULO OBTUSANGULO\n");
        else
            printf("TRIANGULO ACUTANGULO\n");
        if (a == b && b == c)
            printf("TRIANGULO EQUILATERO\n");
        else if (a == b || b == c || c == a)
            printf("TRIANGULO ISOSCELES\n");
    }
    else
        printf("NAO FORMA TRIANGULO\n");

    return 0;
}