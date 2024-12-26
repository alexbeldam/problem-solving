#include <stdio.h>
 
int main() 
{
    double grade[2], average;

    scanf("%lf %lf", &grade[0], &grade[1]);

    average = (grade[0] * 3.5 + grade[1] * 7.5) / 11;

    printf("MEDIA = %.5lf\n", average);
 
    return 0;
}
