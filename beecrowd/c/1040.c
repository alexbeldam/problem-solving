#include <stdio.h>
 
int main() 
{
    double grade[5], average;

    for (int i = 0; i < 4; i++)
      scanf("%lf", &grade[i]);

    average = (grade[0] * 2 + grade[1] * 3 + grade[2] * 4 + grade[3]) / 10;

    printf("Media: %.1lf\n", average);

    if (average >= 7)
        printf("Aluno aprovado.\n");
    else if (average < 5)
        printf("Aluno reprovado.\n");
    else {
        printf("Aluno em exame.\n");

        scanf("%lf", &grade[4]);

        printf("Nota do exame: %.1lf\n", grade[4]);

        average = (average + grade[4]) / 2;

        if (average >= 5)
        printf("Aluno aprovado.\n");
        else
        printf("Aluno reprovado.\n");

        printf("Media final: %.1lf\n", average);
    }
 
    return 0;
}
