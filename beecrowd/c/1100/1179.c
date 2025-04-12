#include <stdio.h>

int main()
{
    int odd[5], evn[5], x, contd, contv;

    for (int i = contd = contv = 0; i < 15; i++) {
        scanf("%d", &x);

        if (contv == 5) {
            for (contv = 0; contv < 5; contv++)
                printf("par[%d] = %d\n", contv, evn[contv]);
            contv = 0;
        }

        if (contd == 5) {
            for (contd = 0; contd < 5; contd++)
                printf("impar[%d] = %d\n", contd, odd[contd]);
            contd = 0;
        }

        if (x % 2 == 0) {
            evn[contv] = x;
            contv++;
        }
        else {
            odd[contd] = x;
            contd++;
        }
    }

    return 0;
}
