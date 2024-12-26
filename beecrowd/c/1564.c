#include <stdio.h>
 
int main() 
{
    for (int n; scanf("%d", &n) != EOF;) {
        if (!(n))
            printf("vai ter copa!\n");
        else
            printf("vai ter duas!\n");
    }
 
    return 0;
}