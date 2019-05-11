/*
1. - a) Crea un programa o método que escriba los n-primeros números primos en un fichero primos.dat
b) Crea un programa o método que lea y muestre por pantalla los números contenidos en el  fichero primos.dat
 */
package Ejercicios2;

/**
 * @proyecto Tema10-Ficheros
 * @fecha 22-abr-2019 12:37:48
 * @author SantiPG
 */
import java.io.*;

public class Ejercicios2_1 {

    public static void main(String[] args) {
        File primos = new File("C:\\Users\\santi\\Desktop\\ArchivosU10\\primos.txt");
        int num = 0;
        int primo;

        try {
            if (primos.exists()) {
                System.out.println("primos.txt ya existe");
            } else {
                primos.createNewFile();
                System.out.println("primos.txt creado con éxito");
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 100; i++) {
            if (i%2==0){
                primo = i;
                System.out.println(primo);
            }

        }

    }

}
