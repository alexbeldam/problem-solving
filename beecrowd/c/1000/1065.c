#include <stdio.h>
 
int main() 
{ 
    int x, even = 0;

    for (int n = 5; n--;) {
        scanf("%d", &x);

        even += (x % 2 == 0);
    }

    printf("%d valores pares\n", even);
  
    return 0;
}