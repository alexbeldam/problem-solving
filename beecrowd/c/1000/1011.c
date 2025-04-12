#include <stdio.h>
#include <math.h>
 
int main() 
{
    double sphere;

    scanf("%lf", &sphere);

    sphere = (4.0 / 3) * 3.14159 * pow(sphere, 3);
    
    printf("VOLUME = %.3lf\n", sphere);
 
    return 0;
}
