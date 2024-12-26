#include <stdio.h>

int main ()
{
  int fat[13] = {1}, n;

  for (int i = 1; i < 13; i++)
    fat[i] = fat[i - 1] * i;

  scanf ("%d", &n);

  printf ("%d\n", fat[n]);

  return 0;
}
