#include <stdio.h>
 
int main() 
{
    double salary;
    
    scanf("%lf", &salary);

    if (salary <= 2000)
        printf ("Isento\n");

    else {
        if (salary <= 3000)
            salary = (salary - 2000) * 0.08;
    
        else if (salary <= 4500)
            salary = 80 + (salary - 3000) * 0.18;

        else
            salary = 350 + (salary - 4500) * 0.28;
        
        printf("R$ %.2lf\n", salary);
    }

    return 0;
}
