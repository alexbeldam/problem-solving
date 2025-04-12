#include <stdio.h>

int main ()
{
    int chars;
    char phrase[] = "LIFE IS NOT A PROBLEM TO BE SOLVED";

    scanf("%d", &chars);

    for (int i = 0; i < chars; i++)
        printf("%c", phrase[i]);
    printf("\n");
}