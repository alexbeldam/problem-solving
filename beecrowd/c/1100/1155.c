#include <stdio.h>

int main ()
{
  double sum = 0;

  for (double i = 1; i <= 100; i++)
    sum += 1 / i;

  printf ("%.2f\n", sum);

  return 0;
}
