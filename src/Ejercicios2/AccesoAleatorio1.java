/*
1. - Escribe un programa que acceda aleatoriamente a un fichero de texto.
El programa debe preguntar al usuario posiciones del fichero y
convertir a mayúsculas el carácter leído en esa posición.
El programa acabará cuando la posición solicitada sea -1
 */
package Ejercicios2;

/**
 * @proyecto Tema10-Ficheros
 * @fecha 26-abr-2019 12:06:21
 * @author SantiPG
 */
import java.io.*;
import java.util.*;

public class AccesoAleatorio1 {

    public static void main(String[] args) {

        File archivo = new File(".\\Archivos\\AccesoAleatorio1.txt");
        int pos;
        Scanner lector = new Scanner(System.in);
        System.out.println("Que posición quieres convertir a mayusculas?");
        pos = lector.nextInt();
        RandomAccessFile raf = null;

        try {
            if (archivo.exists()) {
                System.out.println("AccesoAleatorio1.txt ya existe");
            } else {
                archivo.createNewFile();
                System.out.println("AccesoAleatorio1.txt creado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            raf = new RandomAccessFile(archivo, "rw");
            long tam = raf.length();
            raf.seek(pos);
            if (raf.getFilePointer()<tam){
                int carac = raf.read();
                raf.seek(raf.getFilePointer()-1);
                raf.write(Character.toUpperCase(carac));
            }
        } catch (FileNotFoundException fn) {
            fn.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
