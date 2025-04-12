#include <stdio.h>
 
int main() 
{
    int x, y, sum = 0;

    scanf("%d %d", &x, &y);

    for (y++; y < x; y++) {
        if (y % 2 != 0)
            sum += y;
    }

    printf("%d\n", sum);
 
    return 0;
}
