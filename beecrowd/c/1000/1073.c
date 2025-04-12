#include <stdio.h>
#include <math.h>

int main()
{
    int x, evn;
    long square;

    scanf("%d", &x);

    for (evn = 2; evn <= x; evn += 2)
    {
        square = pow(evn, 2);
        printf("%d^2 = %ld\n", evn, square);
    }

    return 0;
}
