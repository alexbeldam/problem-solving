#include <stdio.h>
#include <string.h>
#include <math.h>

int dec(char *bin)
{
    int sum = 0;

    for (int i = 0; i < 3; i++)
        sum += (bin[i] - '0') * pow(2, 2 - i);

    return sum;
}

int main()
{
    int sum = 0, cont = 0;
    char input[8];

    while (cont != 3)
    {
        scanf(" %[^\n]", input);

        if (strcmp(input, "caw caw") == 0)
        {
            printf("%d\n", sum);
            cont++;
            sum = 0;
        }
        else
        {
            for (int i = 0; i < 3; i++)
                switch (input[i])
                {
                    case '*':
                        input[i] = '1';
                        break;

                    default:
                        input[i] = '0';
                }

            sum += dec(input);
        }
    }

    return 0;
}