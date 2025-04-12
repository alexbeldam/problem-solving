#include <stdio.h>

int main() {

    int n, times, code;
    double price[5] = {1.5, 2.5, 3.5, 4.5, 5.5}, total = 0;

    scanf("%d", &n);

    while (n--)
    {
        scanf("%d %d", &code, &times);
        
        total += price[code - 1001] * times;
    }
  
    printf("%.2f\n", total);

    return 0;
}
