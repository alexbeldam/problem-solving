#include <stdio.h>
 
int main() 
{ 
    int i, j;

    for (i = 1; i < 10; i += 2)
        for (j = 7; j > 4; j--) {
            printf("I=%d ", i);
            printf("J=%d\n", j);
        }
 
    return 0;
}
