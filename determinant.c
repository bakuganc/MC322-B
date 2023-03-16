#include"funcoes.h"
#include <stdio.h>
#include <stdlib.h>

int main(){
    int x = 0;
    int y = 0;
    int m[2][2];
    float det;
    float pre_hip;
    float hip;

    printf("digite os 4 numeros:");

    for (int i = 0;i < 2; i++) {
       for (int j = 0;j < 2;j++) {
            scanf("%d",&m[i][j]);
       }
    }

    
    det = (((m[0][0])*(m[1][1]))-((m[0][1])*(m[1][0])));
      
    if (det>0){
      printf("determinante positivo !");
      pre_hip = (2*det);
      hip = RaizChata(pre_hip);
      printf("\n%3.f\n\n",det);
      printf("%3.f\n\n",hip);  
      printf("hipotenusa do triangulo retangulo igual a %2.f",hip);  
    }

    if (det<0){
      printf("determinante negativo !");
    }

    if (det==0){
      printf("determinante nulo !");
    }

}