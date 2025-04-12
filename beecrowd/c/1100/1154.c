#include <stdio.h>

int main ()
{
  int i, x;
  double sum;

  for (i = sum = 0; 1; i++) 
  {
    scanf("%d", &x);

    if(x<0)
      break;

    sum += x;
  }

  printf ("%.2f\n", sum / i);

  return 0;
}
