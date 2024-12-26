#include <stdio.h>
 
int main() 
{ 
    int pos = 0;
    double x;

    for (int i = 6; i > 0; i--) {
        scanf("%lf", &x);
        
        pos += (x > 0);
    }

    printf("%d valores positivos\n", pos);
  
    return 0;
}
