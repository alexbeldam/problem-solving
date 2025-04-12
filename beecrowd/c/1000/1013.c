#include <stdio.h>
#include <stdlib.h>

int main() {

    int abc, bgt = 0;
    
    for (int i = 0; i <= 2; i++) {
        scanf("%d", &abc);
    
        bgt = (abc + bgt + abs(abc - bgt)) / 2;
    }

    printf("%d eh o maior\n", bgt);

    return 0;
}
