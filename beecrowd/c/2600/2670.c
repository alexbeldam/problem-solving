#include <stdio.h>
 
int main() 
{
    int a[3], tm[3], btm;

    //tm = time/btm = best time//

    scanf("%d %d %d", &a[0], &a[1], &a[2]);

    tm[0] = a[1] * 2 + a[2] * 4;
    tm[1] = a[0] * 2 + a[2] * 2;
    tm[2] = a[0] * 4 + a[1] * 2;

    if (tm[0] < tm[1])
        btm = tm[0];
    else
        btm = tm[1];
    if (btm > tm[2])
        btm = tm[2];
    
    printf("%d\n", btm);
 
    return 0;
}
