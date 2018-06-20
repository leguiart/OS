
#include <math.h>
#include <stdio.h>
#include <unistd.h>
using namespace std;
//Funcion para calcular la serie de fibonacci
int fibonacci(int n) 
{
    if (n<2)
        return n;
    else
        return fibonacci(n-1) + fibonacci(n-2);
}

//Padre con 3 hijos
main()
{
 pid_t pid;//Process ID
 int i;
 
 for(i=1;i<=3;i++)//Ciclo for para crear 3 hijos
{
  
  pid=fork(); 
  if(pid)
  {
   printf("Soy el proceso padre\n");
//Codigo para el padre
   sleep(2);
  }

  else 
  {
   printf("Soy el proceso hijo PID: %d\n",getpid());
//Codigo para los hijos
   int resultado=0;
    printf("Serie de Fibonacci\n");
    for(int j=0;j<100-1;j++)
    {
     resultado = fibonacci(j); //Llamado de la funcion fibonacci definida
     printf("%d\n",resultado);
    }
    printf("Calculo de raiz cuadrada\n");//Calculo de las raices cuadradas
    for(double k=0;k<100;k++)
    {
    k = sqrt(k);
    printf("%lf\n",k);
    }
    printf("Suma de los valores\n"); //Suma de los valores recibidos
    int m;
    int suma=0, arr[100];
    suma = arr[m] + suma; 
    printf("%d", suma);
  }
   sleep(2);
}
  return 0;
 }
 

