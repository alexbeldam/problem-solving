#include <stdio.h>
 
int main() 
{ 
    double radius, area;

    scanf("%lf", &radius);

    area = (radius * radius) * 3.14159;

    printf("A=%.4lf\n", area);
 
    return 0;
}
