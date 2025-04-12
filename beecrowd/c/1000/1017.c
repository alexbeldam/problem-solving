#include <stdio.h>
 
int main() 
{ 
    int hours, km_h;

    scanf("%d %d", &hours, &km_h);

    printf("%.3lf\n", hours * km_h / 12.0);
 
    return 0;
}
