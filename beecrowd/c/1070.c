#include <stdio.h>
 
int main() 
{
    int x, odd;

    scanf("%d", &x);

    for (odd = x++; odd <= x + 10; odd++) {
        if(odd % 2 != 0)
            printf("%d\n", odd);
    }
 
    return 0;
}
