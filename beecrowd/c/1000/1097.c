#include <stdio.h>
 
int main() 
{ 
    int i, j;

    for (i = 1, j = 7; i < 10; i += 2, j += 5)
        for (int n = 0; n < 3; j--, n++) {
            printf("I=%d ", i);
            printf("J=%d\n", j);
        }
 
    return 0;
}
