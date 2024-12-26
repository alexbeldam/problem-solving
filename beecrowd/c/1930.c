#include <stdio.h>
 
int main() 
{
    int sum = 0, t;
    
    for (int i = 0; i < 4; i++)
    {
        scanf("%d", &t);
        
        sum += t;
    }
    
    printf("%d\n", sum - 3);
 
    return 0;
}