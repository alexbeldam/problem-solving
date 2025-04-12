#include <stdio.h>
 
int main() {
 
    int d[2], hr[2], m[2], s[2], dseg, dyseg[2], days, h, min, seg;

    for (int i = 0; i < 2; i++) {
        scanf("%*s %d", &d[i]);
        scanf("%d %*s %d %*s %d", &hr[i], &m[i], &s[i]);

        dyseg[i] = s[i] + (m[i] * 60) + (hr[i] * 3600) + (d[i] * 86400);
    }

    dseg = dyseg[1] - dyseg[0];
    days = dseg / 86400;
    dseg = dseg % 86400;
    h = dseg / 3600;
    dseg = dseg % 3600;
    min = dseg / 60;
    seg = dseg % 60;

    printf("%d dia(s)\n%d hora(s)\n%d minuto(s)\n%d segundo(s)\n", days, h, min, seg);
 
    return 0;
}