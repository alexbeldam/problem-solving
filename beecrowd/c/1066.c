#include <stdio.h>
 
int main() {
 
    int x, i = 5, par = 0, pos = 0, neu = 0;

    while (i--) {
        scanf("%d", &x);

        if (x % 2 == 0)
            par++;
        if (x > 0)
            pos++;
        else if (x == 0)
            neu++;
    }
    
    printf("%d valor(es) par(es)\n%d valor(es) impar(es)\n", par, 5 - par);
    printf("%d valor(es) positivo(s)\n%d valor(es) negativo(s)\n", pos, 5 - pos - neu);

    return 0;
}