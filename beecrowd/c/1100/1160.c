#include <stdio.h>

int main()
{
    int i[2][2];
    double g[2];

    scanf("%d", &i[0][0]);

    while (i[0][0]--)
    {
        scanf("%d %d %lf %lf", &i[1][0], &i[1][1], &g[0], &g[1]);

        i[0][1] = 0;
        g[0] = (g[0] / 100) + 1;
        g[1] = (g[1] / 100) + 1;

        while (i[1][0] <= i[1][1])
        {
            i[1][0] *= g[0];
            i[1][1] *= g[1];
            i[0][1]++;

            if (i[0][1] > 100)
            {
                printf("Mais de 1 seculo.\n");
                break;
            }
        }
        if (!(i[0][1] > 100))
            printf("%d anos.\n", i[0][1]);
    }

    return 0;
}