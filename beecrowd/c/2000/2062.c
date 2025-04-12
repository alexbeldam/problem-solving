#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
int main()
{
    char **string;
    int n;

    scanf("%d", &n);

    string = (char **) malloc (n * sizeof(char *));

    for (int i = 0; i < n; i++)
    {
        string[i] = (char *) malloc (21);

        scanf(" %s", string[i]);

        if (strlen(string[i]) == 3 && ((string[i][0] == 'U' && string[i][1] == 'R') || (string[i][0] == 'O' && string[i][1] == 'B')))
            string[i][2] = 'I';

        if (i != 0)
            printf(" ");

        printf("%s", string[i]);
        
        free(string[i]);
    }
    
    free(string);

    printf("\n");    

    return 0;
}