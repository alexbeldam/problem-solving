#include <stdio.h>

int main()
{
  int slugs, velocity, biggest = 0;

  for (; scanf("%d", & slugs) != EOF; biggest = 0) {
    for (int i = 0; i < slugs; i++) 
    {
      scanf("%d", &velocity);

      if (velocity > biggest)
        biggest = velocity;
    }

    if (biggest < 10)
      biggest = 1;
    else if (biggest < 20)
      biggest = 2;
    else
      biggest = 3;

    printf("%d\n", biggest);
  }

  return 0;
}