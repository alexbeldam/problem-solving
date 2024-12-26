#include <stdio.h>

int main()
{
    int x, y, th, sum = 0;

    scanf("%d %d", &x, &y);

    if (y > x)
        for (th = x; th <= y; th++) {
            if (th % 13 != 0)
                sum += th;
        }
    else
        for (th = y; th <= x; th++) {
            if (th % 13 != 0)
                sum += th;
        }
    
    printf("%d\n", sum);

    return 0;
}