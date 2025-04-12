#include <stdio.h>

int main()
{
    for (int x; 1 == scanf("%d", &x);)
    {
        if (x == 0)
            break;

        if ((x - 1) % 2 == 0)
            x += 1;

        int sum = 0;

        for (int i = 0; i < 5; x += 2, i++) 
            sum += x;

        printf("%d\n", sum);
    }

    return 0;
}
