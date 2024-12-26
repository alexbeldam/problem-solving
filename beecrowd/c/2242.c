#include <stdio.h> 
#include <stdlib.h> 
#include <string.h>  

int main() 
{     
    char string[60], *vow;     
    int i, j;      
    
    fgets(string, 59, stdin);    
        
    vow = malloc (strlen(string) + 1); 

    for (i = j = 0; i < strlen(string); i++) 
    {         
        if (string[i] == 'a' || string[i] == 'e' || string[i] == 'i' || string[i] == 'o' || string[i] == 'u') 
        {             
            vow[j] = string[i];             
            j++;         
        }     
    }  

    vow[j] = '\0';    
    
    for (i = 0, j = strlen(vow) - 1; i < j; i++, j--) 
        if (vow[i] != vow[j]) 
        {
            puts("N");

            free(vow);

            return 0;
        }
    
    puts("S");

    free(vow);
        
    return 0; 
}