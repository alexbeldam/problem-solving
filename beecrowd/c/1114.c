#include <stdio.h>
 
int main() {
 
    int x;

    while (scanf("%d", &x) != EOF) {
        if (x != 2002)
            printf("Senha Invalida\n");
        else
            break;
    }
    printf("Acesso Permitido\n");
 
    return 0;
}