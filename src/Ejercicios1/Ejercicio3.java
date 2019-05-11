package Ejercicios1;

/*
3. - A partir de un fichero de texto se creará un fichero cuyo contenido se
obtendrá a partir del primero. El fichero creado contendrá solo las líneas
del primer fichero que superen o igualen un determinado número de
caracteres. Se solicitará al usuario el nombre de los ficheros y el tamaño
mínimo que debe tener la línea.
 */

/**
 * @proyecto Tema10-Ficheros
 * @fecha 21-abr-2019 11:47:01
 * @author SantiPG
 */
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

public class Ejercicio3 {

    public static void main(String[] args) {
        System.out.println("Introduce el nombre del archivo original");
        Scanner lector = new Scanner(System.in);
        String palabra;
        String nom1 = lector.nextLine();

        File archivo1 = new File("C:\\Users\\santi\\Documents\\NetBeansProjects\\Tema10-Ficheros\\" + nom1 + ".txt");
        try {
            if (archivo1.exists()) {
                System.out.println("Ya existe un archivo con ese nombre, no se ha creado");
            } else if (archivo1.createNewFile()) {
                System.out.println("Se ha creado el archivo " + nom1 + ".txt");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Escribe el contenido del archivo " + nom1 + ".txt");
        String contenido = lector.nextLine();

        try {
            FileWriter fw = new FileWriter(archivo1);
            fw.write(contenido);
            fw.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Ahora introduce el nombre del fichero resultado");

        String nom2 = lector.nextLine();

        File archivo2 = new File("C:\\Users\\santi\\Documents\\NetBeansProjects\\Tema10-Ficheros\\" + nom2 + ".txt");
        try {
            if (archivo2.exists()) {
                System.out.println("Ya existe un archivo con ese nombre, sobreescribir este archivo? (S/N)");
                String opcion = lector.nextLine();
                if (opcion.equalsIgnoreCase("s")) {
                    archivo2.createNewFile();

                } else {
                    System.out.println("No se ha creado el archivo");
                }
            } else {
                archivo2.createNewFile();
                System.out.println("Se ha creado el archivo " + nom2 + ".txt");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Cual es la maxima longitud de las palabras que se van a copiar a " + nom2 + ".txt?");
        int longitud;
        try{
            longitud = lector.nextInt();
        }catch (InputMismatchException ime){
            System.out.println("Valor no valido, ponemos longitud a 3");
            longitud=3;
            ime.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo1));
            palabra = br.readLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo2));

            while (palabra != null) {
                if (palabra.length() <= longitud) {
                    bw.write(palabra + " ");

                }
            }
            if (bw!=null){
                bw.close();
            }
            if (br!=null){
                br.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
