#include <stdio.h>

int main()
{
    int tm[2], h;

    for (int i = 0; i < 2; i++)
        scanf("%d", &tm[i]);

    if (tm[1] < tm[0])
        tm[1] = tm[1] + 24;

    h = tm[1] - tm[0];

    if (h == 0)
        h = 24;
        
    printf("O JOGO DUROU %d HORA(S)", h);

    return 0;
}