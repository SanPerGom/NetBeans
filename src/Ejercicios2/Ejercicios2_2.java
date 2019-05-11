/*
2. - a) Crea un programa o método que escriba  registros de una archivo  en el fichero de datos archivo.dat
Los datos de la archivo son: 
String nombre 
String direccion 
long telefono 
String email 
 
b) Crea un programa o método que lea y muestre por pantalla  los registros contenidos en el  fichero archivo.dat 
 */
package Ejercicios2;

/**
 * @proyecto Tema10-Ficheros
 * @fecha 22-abr-2019 17:35:52
 * @author SantiPG
 */
import java.io.*;

public class Ejercicios2_2 {

    public static void main(String[] args) throws FileNotFoundException {

        Agenda uno = new Agenda("Antonio", "C/ Jesus", "tonicc@gmail.com", 654879261);
        Agenda dos = new Agenda("Maria", "C/ Mayor", "meripe@hotmail.com", 627484587);
        File directorio = new File("./Archivos");
        directorio.mkdir();
        File archivo = new File("./Archivos/Agenda.dat");

        try {
            if (!archivo.exists()) {

                archivo.createNewFile();
                System.out.println("Agenda.dat creado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(uno);
            oos.writeObject(dos);
            oos.flush();
            oos.close();
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Agenda lectura = (Agenda) ois.readObject();
            System.out.println(lectura);
            Agenda lectura2 = (Agenda) ois.readObject();
            System.out.println(lectura2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
