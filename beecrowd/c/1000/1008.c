#include <stdio.h>
 
int main() 
{
    int numb, hour;
    double pay;

    scanf("%d %d %lf", &numb, &hour, &pay);

    printf("NUMBER = %d\nSALARY = U$ %.2f\n", numb, hour * pay);

    return 0;
}
