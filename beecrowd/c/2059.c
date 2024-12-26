#include <stdio.h>

int main()
{
    int choice, number[2], cheat[2], winner;

    scanf("%d %d %d %d %d", &choice, &number[0], &number[1], &cheat[0], &cheat[1]);

    if ((choice == 1 && (number[0] + number[1]) % 2 == 0) || (choice == 0 && (number[0] + number[1]) % 2 != 0))
    {
        winner = 1;

        if (cheat[0] == 1 && cheat[1] == 1)
            winner = 2;
    }
    else
    {
        winner = 2;

        if ((cheat[0] == 1 && cheat[1] == 0) || (cheat[0] == 0 && cheat[1] == 1))
            winner = 1;
    }

    printf("Jogador %d ganha!\n", winner);

    return 0;
}
