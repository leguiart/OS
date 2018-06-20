//El programa esta creado en dos archivos de java, uno contiene a la clase 
// a partir de la cual se crearan los hilos (clase Proceso) y el otro
// contiene al metodo main y es donde se crearan las instancias de la clase
// Proceso que a su vez hereda de la clase Thread y donde se utilizaran
// los metodos correspondientes que fueron incorporados a esta clase para 
// lograr que los hilos descargaran cada uno el contenido de su respectivo
// URL y lo guardasen en un archivo, asi como lo imprimiesen en pantalla,
//  esto ultimo como una forma de verificar el paralelismo de ejecucion en los 
// hilos
package hilos; // Se declara el paquete del cual es parte este codigo y asi
// funcione de forma modular con cualquier otro programa dentro del mismo archivo
// y que tenga declarada la pertenencia al mismo paquete 

/**
 *
 * @author Luis
 */
public class Hilos //La clase se declara como publica porque contiene al main
{
    public static void main(String[] args) 
    {
        //Se crean tres objetos Proceso que al heredar de la clase Thread
        // basicamente lo que hace el constructor es crear un objeto Thread
        // respectivo asociado a la instancia de la clase Proceso
        Proceso hilo1 = new Proceso("Hilo 1");
        Proceso hilo2 = new Proceso("Hilo 2");
        Proceso hilo3 = new Proceso("Hilo 3");
        // Se le asocia una URL a cada objeto hilo con el metodo asociaProcesoURL
        hilo1.asociaProcesoURL("http://jarroba.com/");
        hilo2.asociaProcesoURL("http://codigoprogramacion.com/");
        hilo3.asociaProcesoURL("http://www.chuidiang.com/");
        // Se le asocia a cada hilo un nombre de archivo  que  en caso de 
        // no existir creara,donde depositara la descarga de la pagina respectiva asociada a este
        hilo1.asociaArchivo("Hilo1.txt");
        hilo2.asociaArchivo("Hilo2.txt");
        hilo3.asociaArchivo("hilo3.txt");
        // Se utiliza el metodo start() para inicializar cada hilo
        // y que ejecuten su metodo run()
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
