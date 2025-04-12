#include <stdio.h>

int main()
{
    double a, b, c, area[5];

    scanf("%lf %lf %lf", &a, &b, &c);

    area[0] = (a * c)  / 2;
    area[1] = c * c * 3.14159;
    area[2] = (a + b) * c / 2;
    area[3] = b * b;
    area[4] = a * b;

    printf("TRIANGULO: %.3lf\n", area[0]);
    printf("CIRCULO: %.3lf\n", area[1]);
    printf("TRAPEZIO: %.3lf\n", area[2]);
    printf("QUADRADO: %.3lf\n", area[3]);
    printf("RETANGULO: %.3lf\n", area[4]);

    return 0;
}
