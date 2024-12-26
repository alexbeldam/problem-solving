#include <stdio.h>
 
int main() 
{
    double a, b, c, av;

    scanf("%lf %lf %lf", &a, &b, &c);

    av = (a * 2 + b * 3 + c * 5) / 10;

    printf("MEDIA = %.1f\n", av);

    return 0;
}
