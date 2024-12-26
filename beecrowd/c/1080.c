#include <stdio.h>

int main()
{
    int x, bgt = 0, bgp;

    for (int i = 1; i < 101; i++) {
        scanf("%d", &x);
    
        if(x > bgt)  {
            bgt = x;
            bgp = i;
        }
    }

    printf("%d\n%d\n", bgt, bgp);

    return 0;
}
