#include <stdio.h>
 
int main() 
{ 
    int x;

    scanf("%d", &x);

    for(int i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", i, x, x * i);
    }
 
    return 0;
}
