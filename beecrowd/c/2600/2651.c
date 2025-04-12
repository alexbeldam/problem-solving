#include <stdio.h>
#include <string.h>
#include <ctype.h>
 
int main() 
{
    char name[100001];

    fgets(name, 100000, stdin);

    for (int i = 0; i < strlen(name); i++)
        name[i] = tolower(name[i]);

    strstr(name, "zelda") != NULL ? puts("Link Bolado") : puts("Link Tranquilo");

    return 0;
}