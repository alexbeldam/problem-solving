#include <stdio.h>

int main () 
{
  int fib[46] = {0, 0, 1}, n;

  for (int i = 3; i < 46; i++)
    fib[i] = fib[i - 1] + fib[i - 2];

  scanf ("%d", &n);

  for (int i = 1; i < n; i++)
    printf ("%d ", fib[i]);

  printf ("%d\n", fib[n]);

  return 0;
}
