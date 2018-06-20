package hilos;

import java.io.BufferedInputStream; 
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.File;
import java.io.FileWriter;

class Proceso extends Thread 
{
    //Se declaran variables que serviran fuera de los metodos
    //Porque estas actuaran en toda la clase 
    // Y si se quiere especificar su uso en cada metodo referido a una instancia
    // se utiliza el operador this
    String msg;// Variable msg para guardar un nombre del Hilo
    URL url2;//Variable para asociar a cada instancia de la clase
    // Proceso un objeto de la clase URL
    Thread t; // Variable para la creacion del hilo correspondiente
    //Y para poder ejecutar el metodo run en forma de hilo
    File f2; // Manejador del archivo
    //Metodo constructor
    Proceso(String msg)
    {
        this.msg=msg;
        t= new Thread(this.msg);
    }
    //Metodo para asociar al hilo con un objeto URL
    //Con el cual se pudiesen efectuar las operaciones de descarga
    // del contenido y la asi como la impresion en pantalla y guardado
    // de este contenido en archivos
    public void asociaProcesoURL(String url)
    {
        try {
            URL url2 = new URL(url);
            this.url2=url2;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    //Metodo para crear un archivo asociado al hilo donde 
    // descargara la informacion
    public void asociaArchivo(String nombre)
    {
        this.f2 = new File(nombre);
         if(!f2.exists())
        {
            //Si no existe el programa intentará crearlo, como esto puede arrojar una excepción se utiliza la sentencia try catch
            try
            {
                this.f2.createNewFile();
            }
            catch(IOException io)
            {System.out.println("Error: " + io.toString());}   
        }
    }
    //Metodo run donde se efectua tanto la operacion en manejo, escritura
    // Y guardado del archivo asi como la operacion de descarga con la clase 
    //URL e impresion en pantalla
    @Override
    public void run()
    {
        try
        {
            URLConnection urlc = this.url2.openConnection();
 
            BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());
            FileWriter fw = new FileWriter(this.f2);
 
            StringBuilder builder = new StringBuilder();
            int byteRead;
            //Lo que realmente esta ejecutando cada hilo
            // o mas bien el 'proceso fuerte' que esta realizando cada hilo
            // se realiza en este ciclo while(la concatenacion de lo descargado
            // al objeto StringBuilder y la concatenacion de cadenas al archivo)
            while ((byteRead = buffer.read()) != -1)
            {
                builder.append((char) byteRead);
                fw.append((char) byteRead);                
            }
            fw.append("\n The size of the web page is " + builder.length() + " bytes.");
            
            fw.close();
            buffer.close();
            
            System.out.println(builder.toString());
            System.out.println("\n \n The size of the web page is " + builder.length() + " bytes. \n \n");
            System.out.println("***************************************************************"
                    + "****************************************************************************************** \n \n \n \n \n");
 
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }   
}
