#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *hexify(int dec) {
    char * aux = (char *) malloc (51), * hex;

    strcpy(aux, "");

    while (dec != 0) {
        char c;
        int rem = dec % 16;

        if (rem < 10)
            c = rem + 48;
        else 
            c = rem + 55;

        strncat(aux, &c, 1);

        dec /= 16;
    }

    hex = (char *) malloc (strlen(aux) + 1);

    for (int i = 0; i < strlen(aux); i++) 
        hex[i] = aux[strlen(aux) - 1 - i];
    hex[strlen(aux)] = '\0';

    free(aux);

    return hex;
}

int main() {
    int dec;

    scanf("%d", &dec);
    printf("%s\n", hexify(dec));

    return 0;
}