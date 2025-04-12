#include <stdio.h>

int getcpf(int cpf[11])
{
    int c, p, f, digits, i, j;
    char trash;

    if (scanf("%d%c", &c, &trash) != EOF)
    {
        scanf("%d%c", &p, &trash);
        scanf("%d%c", &f, &trash);
        scanf("%d", &digits);

        for (i = 0, j = 1000; i < 3; i++, c %= j)
        {
            j /= 10;

            cpf[i] = c / j;
        }
        for (i = 3, j = 1000; i < 6; i++, p %= j)
        {
            j /= 10;

            cpf[i] = p / j;
        }
        for (i = 6, j = 1000; i < 9; i++, f %= j)
        {
            j /= 10;

            cpf[i] = f / j;
        }
        for (i = 9, j = 100; i < 11; i++, digits %= j)
        {
            j /= 10;

            cpf[i] = digits / j;
        }

        return 1;
    }

    return EOF;
}

int cpf_validation(int cpf[11])
{
    int digits[2] = {};

    for (int i = 0; i < 9; i++)
        digits[0] += cpf[i] * (1 + i);

    for (int i = 0; i < 9; i++)
        digits[1] += cpf[i] * (9 - i);

    for (int i = 0; i < 2; i++)
    {
        digits[i] %= 11;

        digits[i] = digits[i] == 10 ? 0 : digits[i];

        if (digits[i] != cpf[9 + i])
            return 0;
    }

    return 1;
}

int main()
{
    int cpf[11];

    while (getcpf(cpf) != EOF)
    {
        if (cpf_validation(cpf))
            puts("CPF valido");
        else
            puts("CPF invalido");
    }

    return 0;
}