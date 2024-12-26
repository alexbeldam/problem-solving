#include <stdio.h>

int main()
{
    int x, y, z, ma, me, men, aux;

    scanf("%d %d %d", &x, &y, &z);

    ma = x;
    me = y;
    men = z;

    if (ma < men)
    {
        aux = ma;
        ma = men;
        men = aux;
    }
    if (me < men)
    {
        aux = men;
        men = me;
        me = aux;
    }
    if (ma < me)
    {
        aux = ma;
        ma = me;
        me = aux;
    }

    printf("%d\n%d\n%d\n\n%d\n%d\n%d\n", men, me, ma, x, y, z);

    return 0;
}