#include <stdio.h>
#include <string.h>

int main () {
    char string[3][100];

    scanf(" %[^\n]s", string[0]);
    scanf(" %[^\n]s", string[1]);
    scanf(" %[^\n]s", string[2]);

    printf("%s%s%s\n", string[0], string[1], string[2]);
    printf("%s%s%s\n", string[1], string[2], string[0]);
    printf("%s%s%s\n", string[2], string[0], string[1]);
    printf("%.10s%.10s%.10s\n", string[0], string[1], string[2]);
    
    return 0;
}