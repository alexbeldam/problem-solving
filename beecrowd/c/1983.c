#include <stdio.h>

typedef struct {
    unsigned matricula;
    double nota;
} student;

int main()
{
    student highest, input;
    int n;

    highest.nota = 0;

    scanf("%d", &n);

    while (n--)
    {
        scanf("%u %lf", &input.matricula, &input.nota);

        if (input.nota > highest.nota && input.nota >= 8)
        {
            highest.nota = input.nota;
            highest.matricula = input.matricula;
        }
    }

    if (!highest.nota)
        printf("Minimum note not reached\n");
    else
        printf("%u\n", highest.matricula);

    return 0;
}