#include <stdio.h>

int main()
{
    int goal[2], in, gr, tie, i, n;

    for (i = n = tie = in = gr = 0; n != 2; i++)
    {
        scanf("%d %d", &goal[0], &goal[1]);

        if (goal[0] == goal[1])
            tie++;
        else if (goal[0] > goal[1])
            in++;
        else
            gr++;

        printf("Novo grenal (1-sim 2-nao)\n");

        scanf("%d", &n);
    }

    printf("%d grenais\n", i);
    printf("Inter:%d\n", in);
    printf("Gremio:%d\n", gr);
    printf("Empates:%d\n", tie);

    if (in > gr)
        printf("Inter venceu mais\n");
    else
        printf("Gremio venceu mais\n");

    return 0;
}