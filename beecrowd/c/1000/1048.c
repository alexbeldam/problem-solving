#include <stdio.h>

int main()
{
    double salary, rate, reajust;

    scanf("%lf", &salary);

    if (salary <= 400)
        rate = 0.15;
    else if (salary <= 800)
        rate = 0.12;
    else if (salary <= 1200)
        rate = 0.1;
    else if (salary <= 2000)
        rate = 0.07;
    else
        rate = 0.04;

    reajust = (salary * (1 + rate)) - salary;
    salary += reajust;

    printf("Novo salario: %.2f\nReajuste ganho: %.2f\nEm percentual: %.0f %%\n", salary, reajust, rate * 100);

    return 0;
}
