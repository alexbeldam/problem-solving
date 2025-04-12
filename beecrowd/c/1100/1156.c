#include <stdio.h>
#include <math.h>

int main ()
{
  double s;

  for (double i = 1, n = s = 0; i <= 100; i+=2, n++)
    s += i / pow(2, n);

  printf ("%.2f\n", s);

  return 0;
}
