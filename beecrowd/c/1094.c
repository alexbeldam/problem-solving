#include <stdio.h>

int main() 
{
    int i, n, rat, bunny, frog;
    char rbf;
    double sum;
    
    rat = bunny = frog = 0;

    scanf("%d", &i);

    while (i--)
    {
        scanf("%d %c", &n, &rbf);

        bunny += (rbf == 'C') * n;
        rat += (rbf == 'R') * n;
        frog += (rbf == 'S') * n;
    }

    sum = rat + bunny + frog;
  
    printf("Total: %.0f cobaias\n", sum);
    printf("Total de coelhos: %d\n", bunny);
    printf("Total de ratos: %d\n", rat);
    printf("Total de sapos: %d\n", frog);
    printf("Percentual de coelhos: %.2lf %%\n", (bunny / sum) * 100);
    printf("Percentual de ratos: %.2lf %%\n", (rat / sum) * 100);
    printf("Percentual de sapos: %.2lf %%\n", (frog / sum) * 100);

    return 0;
}
