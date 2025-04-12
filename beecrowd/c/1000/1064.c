#include <stdio.h>

int main()
{
    double x, average = 0;
    int n = 6, pos = 0;

    while (n--)
    {
        scanf("%lf", &x);

        pos += (x > 0);
        average += (x > 0) * x;
    }

    printf("%d valores positivos\n%.1lf\n", pos, average / pos);

    return 0;
}