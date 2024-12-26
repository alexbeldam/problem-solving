#include <stdio.h>
 
int main()
{
    double m[12][12], sum = 0;
    char t;

    scanf("%c", &t);

    for (int i = 0; i < 12; i++)
        for (int j = 0; j < 12; j++) 
            scanf("%lf", &m[i][j]);

    for (int i = 11; i > 6; i--)
        for (int j = 12-i; j < i; j++) 
            sum += m[i][j];

    if (t == 'M')
        sum /= 30;
    
    printf("%.1f\n", sum);
 
    return 0;
}