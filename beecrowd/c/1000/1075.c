#include <stdio.h>
 
int main() 
{
    int x, y;

    scanf("%d", &x);

    for(y = 1; y <= 10000; y++) {
        if (y % x == 2)
            printf("%d\n", y);
    }
 
    return 0;
}
