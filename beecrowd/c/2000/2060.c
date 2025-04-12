#include <stdio.h>

int main() 
{
    int n, x, m[4] = {};

    scanf("%d", &n);

    while (n--)
    {
        scanf("%d", &x);
        
        m[0] += (x % 2 == 0);
        m[1] += (x % 3 == 0);
        m[2] += (x % 4 == 0);
        m[3] += (x % 5 == 0);
    }

    printf("%d Multiplo(s) de 2\n", m[0]);
    printf("%d Multiplo(s) de 3\n", m[1]);
    printf("%d Multiplo(s) de 4\n", m[2]);
    printf("%d Multiplo(s) de 5\n", m[3]);
  
    return 0;
}
