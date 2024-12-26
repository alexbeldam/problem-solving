#include <stdio.h>

int main()
{
    int h[2], m[2], tm;

    for (int i = 0; i < 2; i++)
        scanf("%d %d", &h[i], &m[i]);

    tm = (h[1] * 60 + m[1]) - (h[0] * 60 + m[0]);
    tm += 1439;
    tm %= 1440;
    tm++;

    printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", tm / 60, tm % 60);

    return 0;
}
