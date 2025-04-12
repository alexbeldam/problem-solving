#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BOTH 4
#define NOBODY 0
#define AIR -2

typedef char * string;

string *start_game()
{
    string *players = (string *) malloc (2 * sizeof(string));

    for (int i = 0; i < 2; i++)
    {
        players[i] = (string) malloc (10);

        scanf(" %s", players[i]);    
    }

    return players;
}


int winner(string *players)
{
    if (strncmp(players[0], "pe", 2) == 0)
    {
        if (strncmp(players[1], "pa", 2) == 0)
            return 1;
        if (strcmp(players[1], players[0]) == 0)
            return NOBODY;
    }
    if (strncmp(players[0], "pa", 2) == 0)
    {
        if (strncmp(players[1], "pe", 2) == 0)
            return 2;
        if (strcmp(players[1], players[0]) == 0)
            return BOTH;
    }
    if (strncmp(players[0], "at", 2) == 0)
    {
        if (strncmp(players[1], "at", 2) == 0)
            return AIR;
        return 1;
    }
    return 2;
}

void end_game(string *players)
{
    for (int i = 0; i < 2; i++)
        free(players[i]);

    free(players);
}

int main()
{
    int n, win;
    string *players;

    scanf("%d", &n);

    while (n--)
    {
        players = start_game();

        win = winner(players);

        switch (win)
        {
            case NOBODY:
                puts("Sem ganhador");
                break;
            case BOTH:
                puts("Ambos venceram");
                break;
            case AIR:
                puts("Aniquilacao mutua");
                break;
            default:
                printf("Jogador %d venceu\n", win);
        }

        end_game(players);
    }

    return 0;
}