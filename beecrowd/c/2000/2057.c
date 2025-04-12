#include <stdio.h>

int main()
{
    int s, t, f, h;

    scanf("%d %d %d", &s, &t, &f);

    if (s == 0)
        s = 24;

    h = s + t + f;

    if (h >= 24)
        h -= 24;

    printf("%d\n", h);

    return 0;
}