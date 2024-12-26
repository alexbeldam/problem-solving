#include <stdio.h>
#include <math.h>
 
int main() 
{
    double x[2], y[2];

    for (int i = 0; i < 2; i++)
      scanf("%lf %lf", &x[i], &y[i]);

    printf("%.4lf\n", sqrt(pow(x[1] - x[0], 2) + pow(y[1] - y[0], 2)));
 
    return 0;
}
