#include <stdio.h>

int main ()
{
  int n[20];

  for (int i = 19; i > -1; i--)
    scanf("%d", &n[i]);

  for (int i = 0; i < 20; i++)
    printf("N[%d] = %d\n", i, n[i]);

  return 0;
}