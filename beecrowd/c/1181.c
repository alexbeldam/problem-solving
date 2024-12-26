#include <stdio.h>
 
int main() 
{ 
    double m[12][12], sum = 0;
    int l;
    char t;

    scanf("%d", &l);
    scanf(" %c", &t);

    for (int i = 0; i < 12; i++)
        for (int j = 0; j < 12; j++) 
            scanf("%lf", &m[i][j]);

    for (int i = 0; i < 12; i++)
        sum += m[l][i];

    if (t == 'M')
        sum /= 12;
    
    printf("%.1f\n", sum);
 
    return 0;
}