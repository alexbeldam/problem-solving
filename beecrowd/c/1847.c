#include <stdio.h>

char *face(int a, int b, int c)
{
    if (b < a)
    {
        if (c >= b || b - c < a - b)
            return ":)";
        return ":(";
    }
    if (b > a)
    {
        if (c <= b || c - b < b - a)
            return ":(";
        return ":)";
    }
    if (c > b)
        return ":)";
    return ":(";
}

int main()
{
    int a, b, c;

    scanf("%d %d %d", &a, &b, &c);

    printf("%s\n", face(a, b, c));

    return 0;
}