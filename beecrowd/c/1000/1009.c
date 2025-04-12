#include <stdio.h>
 
int main() 
{
    double salary, sales;

    scanf("%*s %lf %lf", &salary, &sales);

    printf("TOTAL = R$ %.2lf\n", salary + sales * 0.15);
     
    return 0;
}
