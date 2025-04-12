#include <stdio.h>
#include <limits.h>
 
int main() {
 
    int x, y = INT_MIN, i = 1;

    scanf("%d", &x);

    while (!(y > x))
        scanf("%d", &y);

    for (int n = x; x <= y; i++) 
        x += n + i;

    printf("%d\n", i);
 
    return 0;
}
