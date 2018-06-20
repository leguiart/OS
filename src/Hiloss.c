#include <stdio.h>
#include <pthread.h>    //biblioteca necesario para el manejo de hilos //

void *saludo(void *);

int main(){
	pthread_t hilo[10],ID[10];										
	int i;												
	for(i=0;i<10;i++)
	pthread_create(&hilo[i],NULL,&saludo,&hilo[i]);	 //se realiza la creacion de los hilos					
	pthread_join(hilo[0],&ID[0]);								
	pthread_join(hilo[1],&ID[1]);	//esperan la terminacion del hilo anterior en cada uno de ellos, en este caso// 				
	pthread_join(hilo[2],&ID[2]);		//son 10 hilos los que se realizaron//						
	pthread_join(hilo[3],&ID[3]);					
	pthread_join(hilo[4],&ID[4]);		//Acompañados su identificador que sera asignado//				
	pthread_join(hilo[5],&ID[5]);					
	pthread_join(hilo[6],&ID[6]);								
	pthread_join(hilo[7],&ID[7]);					
	pthread_join(hilo[8],&ID[8]);								
	pthread_join(hilo[9],&ID[9]);
	
	for(i=0;i<10;i++)
		printf("\nHilo[%d] con identificador [%d]",i,ID[i]);
	printf("\n");
}

void *saludo(void *entrada){
	int ID,i;
	ID = *(int *)entrada;
	for(i=0;i<5;i++) //se hace el ciclo para que cada hilo realice las 5 veces el hola mundo//
		printf("Hola mundo (Hilo %d)\n",ID);
	pthread_exit(ID);	//termina la ejecución del hilo//								
}

