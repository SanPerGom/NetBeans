package Ejercicios1;


/*
1. - A partir de dos ficheros de texto se creará un tercer fichero cuyo contenido se obtendrá uniendo la información de estos ficheros.
Cada línea del fichero creado estará formado por la unión de la misma línea de los dos ficheros leídos. Se solicitará al usuario 
el nombre de los ficheros y la tira de separación entre ambas líneas.
 */

/**
 * @proyecto Tema10-Ficheros
 * @fecha 18-abr-2019 13:28:09
 * @author SantiPG
 */
import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        String ficheroNombres = "Nombres.txt";
        String ficheroApellidos = "Apellidos.txt";
        String ficheroResultado = "Resultado.txt";
        String esp = " ";

        BufferedReader brn = null;
        BufferedReader bra = null;
        BufferedWriter bw = null;

        try {
            brn = new BufferedReader(new FileReader(ficheroNombres));
            bra = new BufferedReader(new FileReader(ficheroApellidos));

            String nombre = brn.readLine();
            String apellido = bra.readLine();

            bw = new BufferedWriter(new FileWriter(ficheroResultado));

            while (nombre != null) {
                
                bw.write(nombre + esp + apellido);
                nombre = brn.readLine();
                apellido = bra.readLine();
                bw.newLine();

            }
            if (bw != null) {
                bw.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (brn != null) {
                    brn.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    }

}
