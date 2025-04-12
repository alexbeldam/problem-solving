#include <stdio.h>
#include <math.h>
 
int main() 
{ 
    int x;
    double base;

    scanf("%d", &x);

    for(base = 1; base <= x; base++) {
        printf("%.0f %.0f %.0f\n", base, pow(base, 2), pow(base, 3));
        printf("%.0f %.0f %.0f\n", base, pow(base, 2) + 1, pow(base, 3) + 1);
    }
 
    return 0;
}
