#include <stdio.h>

int main() {
    int a, b, c, d, q, r;

    scanf("%d %d", &a, &b);


    if (a > 0) {
        q = a / b;
        r = a % b;
    }
    else {
        c = b;

        if (b < 0)
            c = -c;

        for (r = 0; r < c; r++) {
            d = a - r;

            if (d % b == 0)
                break;
        }

        q = d / b;
    }

    printf("%d %d\n", q, r);

    return 0;
}