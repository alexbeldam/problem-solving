#include <stdio.h>
 
int main() 
{ 
    double number;
    int hnd, fifty, twt, ten, five, two, chnd, cfifty, ctwtf, cten, cfive, onec;

    scanf("%lf", &number);

    hnd = number / 100;
    number = number - 100 * hnd; 
    fifty = number / 50;
    number = number - 50 * fifty;
    twt = number / 20;
    number = number - 20 * twt;
    ten = number / 10;
    number = number - 10 * ten;
    five = number / 5;
    number = number - 5 * five;
    two = number / 2;
    chnd = number - 2 * two;
    number = number - 2 * two - chnd;
    cfifty = number / 0.5;
    number = number - 0.5 * cfifty;
    ctwtf = number / 0.25;
    number = number - 0.25 * ctwtf;
    cten = number / 0.1;
    number = number - 0.1 * cten; 
    cfive = number / 0.05;
    number = number - 0.05 * cfive;
    onec = number / 0.01;


    printf("NOTAS:\n");
    printf("%d nota(s) de R$ 100.00\n", hnd);
    printf("%d nota(s) de R$ 50.00\n", fifty);
    printf("%d nota(s) de R$ 20.00\n", twt);
    printf("%d nota(s) de R$ 10.00\n", ten);
    printf("%d nota(s) de R$ 5.00\n", five);
    printf("%d nota(s) de R$ 2.00\n", two);
    printf("MOEDAS:\n");
    printf("%d moeda(s) de R$ 1.00\n", chnd);
    printf("%d moeda(s) de R$ 0.50\n", cfifty);
    printf("%d moeda(s) de R$ 0.25\n", ctwtf);
    printf("%d moeda(s) de R$ 0.10\n", cten);
    printf("%d moeda(s) de R$ 0.05\n", cfive);
    printf("%d moeda(s) de R$ 0.01\n", onec);
 
    return 0;
}
