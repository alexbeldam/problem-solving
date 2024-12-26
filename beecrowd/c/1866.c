#include <stdio.h>

int sum(int n)
{
    int num = 0, i = -1;

    for (int j = 0; j < n; j++)
    {
        i = -i;

        num += i;
    }

    return num;
}

int main()
{
    int n, input;

    scanf("%d", &n);

    while(n--)
    {
        scanf("%d", &input);

        printf("%d\n", sum(input));
    }

    return 0;
}