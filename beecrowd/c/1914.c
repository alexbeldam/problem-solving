#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char **start_game()
{
    char **players = (char **) malloc (2), input[4][20];

    for (int i = 0; i < 4; i++)
        scanf(" %s", input[i]);

    if (strcmp(input[1], "PAR") == 0)
        for (int i = 0, j = 2; i < 2; i++, j -= 2)
        {
            players[i] = (char *) malloc (strlen(input[j]) + 1);

            strcpy(players[i], input[j]);
        }
    else
        for (int i = 0, j = 0; i < 2; i++, j += 2)
        {
            players[i] = (char *) malloc (strlen(input[j]) + 1);

            strcpy(players[i], input[j]);
        }

    return players;
}

void end_game(char **players)
{
    for (int i = 0; i < 2; i++)
        free(players[i]);

    free(players);
}

int main()
{
    int qt;
    long n, m;
    char **players;

    scanf("%d", &qt);

    while(qt--)
    {
        players = start_game();

        scanf("%ld %ld", &n, &m);

        printf("%s\n", players[(n + m) % 2 == 0]);

        end_game(players);
    }

    return 0;
}