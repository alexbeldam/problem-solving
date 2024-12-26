#include <stdio.h>
#include <math.h>
 
int main() 
{ 
    double a, b, c, root[2], delta;

    scanf("%lf %lf %lf", &a, &b, &c);

    delta = pow(b, 2) - 4 * a * c;
    
    if (delta < 0 || a == 0)
        printf("Impossivel calcular\n");
    else {
        root[0] = (-b + sqrt(delta)) / (2 * a);
        root[1] = (-b - sqrt(delta)) / (2 * a);

        printf("R1 = %.5lf\n", root[0]);
        printf("R2 = %.5lf\n", root[1]);
    }

    return 0;
}
