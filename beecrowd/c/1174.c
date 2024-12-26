#include <stdio.h>
 
int main() 
{ 
    double a;

    for (int i = 0; i <= 99; i++)
    {
        scanf("%lf", &a);

        if (a <= 10)
            printf("A[%d] = %.1f\n", i, a);
    }
 
    return 0;
}
