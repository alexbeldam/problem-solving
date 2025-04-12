#include <stdio.h>

int main() 
{
    int x, y, sum;

    while (scanf("%d %d", &x, &y) != EOF)
    {
        if (x <= 0 || y <= 0)
            break;
    
        else if (y>x) {
            sum = y;
            y = x;
            x = sum;
        }

        for (sum = 0; x >= y; y++) {
            printf ("%d ", y);

            sum += y;
        }    
        
        printf("Sum=%d\n", sum);
    }

    return 0;
}
