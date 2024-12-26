#include <stdio.h>
 
int main() 
{
    long long unsigned l, m, n;
    
    scanf("%llu %llu", &n, &l);

    m = n * l;
    
    printf("%llu\n", m);
 
    return 0;
}