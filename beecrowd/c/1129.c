#include <stdio.h>

int main()
{
    for (int n, gray; 1 == scanf("%d", &n);)
    {
        if (n == 0)
            break;

        for (int alt = 65, j; n--; alt = 65)
        {
            for (int i = j = 0; i < 5; i++)
            {
                scanf("%d", &gray);

                if (gray <= 127)
                {
                    alt += i;
                    j++;
                }
            }
            
            if (j != 1)
                alt = 42;
            
            printf("%c\n", alt);
        }
    }

    return 0;
}
