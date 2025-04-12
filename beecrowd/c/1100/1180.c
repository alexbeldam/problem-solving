#include <stdio.h>

int main()
{
    int n, sml[999], smlp = 0;

    scanf("%d", &n);
    
    for (int i = 0; i < n; i++) 
        scanf("%d", &sml[i]);
    for (int i = 1; i < n; i++)
        if (sml[i] <= sml[smlp])
            smlp = i;

    printf("Menor valor: %d\n", sml[smlp]);
    printf("Posicao: %d\n", smlp);

    return 0;
}
