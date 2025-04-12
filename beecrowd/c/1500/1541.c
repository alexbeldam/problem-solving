#include <stdio.h>
#include <math.h>

int dimension(double area, int *sides)
{
    area /= 100;
    area = *(sides) * *(sides + 1) / area;

    return (int)floor(sqrt(area));
}

int main()
{
    int side[2];
    double rate;

    while (scanf("%d", side))
    {
        if (!(*side))
            break;

        scanf("%d %lf", side + 1, &rate);

        printf("%d\n", dimension(rate, side));
    }

    return 0;
}