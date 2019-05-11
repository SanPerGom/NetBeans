package Ejercicios1;

/*
2. - A partir de dos ficheros de texto se creará un tercer fichero cuyo contenido
se obtendrá uniendo la información de estos ficheros. Las líneas del
fichero creado contendrán todas las combinaciones de líneas del primer
fichero con las líneas del segundo. Se solicitará al usuario el nombre de
los ficheros y la tira de separación entre ambas líneas
 */

/**
 * @proyecto Tema10-Ficheros
 * @fecha 21-abr-2019 11:14:55
 * @author SantiPG
 */
import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        String fichero1 = "Nombres.txt";
        String fichero2 = "Apellidos.txt";
        String fichero3 = "Ejer2.txt";

        BufferedReader br1 = null;
        BufferedReader br2 = null;
        BufferedWriter bw = null;

        try {
            br1 = new BufferedReader(new FileReader(fichero1));
            br2 = new BufferedReader(new FileReader(fichero2));

            int carac1 = br1.read();
            int carac2 = br2.read();

            bw = new BufferedWriter(new FileWriter(fichero3));

            while (carac1 != -1 && carac2 != -1) {
                bw.write((char)carac1 +" "+ (char)carac2 + " ");
                carac1 = br1.read();
                carac2 = br2.read();
                bw.newLine();

            }
            if (bw != null) {
                bw.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        try {
            if (br1 != null) {
                br1.close();

            }
            if (br2 != null) {
                br2.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
