#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char* tolowers(char *string)
{
    char *lowstring;

    lowstring = malloc (strlen(string) + 1);

    for (int i = 0; i < strlen(string); i++)
        lowstring[i] = tolower(string[i]);

    return lowstring;
}

int main()
{
    char name[81], last[81];

    scanf(" %[^\n]", last);

    while(scanf(" %[^\n]", name) != EOF)
        if (strcmp(tolowers(last), tolowers(name)) < 0)
            strcpy(last, name);

    puts(last);

    return 0;
}