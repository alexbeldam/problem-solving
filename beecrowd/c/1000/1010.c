#include <stdio.h>
 
int main() 
{
    int times, i=2;
    double number, sum = 0;
    
    while(i--) {
        scanf("%*s %d %lf", &times, &number);

        number *= times;
        sum += number;
    }
    
    printf("VALOR A PAGAR: R$ %.2lf\n", sum);
 
    return 0;
}
