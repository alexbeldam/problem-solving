#include <stdio.h>

int main()
{
    int l, c;

    scanf("%d %d", &l, &c);

    printf("%d\n", (l + c + 1) % 2);

    return 0;
}
