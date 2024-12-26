#include <stdio.h>
 
int main() 
{    
    int n;
    double x, y, z;

    scanf("%d", &n);

    while (n--) {
        scanf("%lf %lf %lf", &x, &y, &z);
        
        printf("%.1f\n", (x * 2 + y * 3 + z * 5) / 10);
    }
 
    return 0;
}
