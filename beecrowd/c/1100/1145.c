#include <stdio.h>
 
int main() 
{ 
    int x, y;

    scanf("%d %d", &x, &y);

    for (int i = 1; i <= y; i++) {
        for (int n = 1; n < x; n++, i++) 
            printf("%d ", i);
        printf("%d\n", i);
    }
 
    return 0;
}
