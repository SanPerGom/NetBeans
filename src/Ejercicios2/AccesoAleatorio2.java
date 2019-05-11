/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios2;

/**
 * @proyecto Tema10-Ficheros
 * @fecha 26-abr-2019 12:45:16
 * @author SantiPG
 */
import java.io.*;

public class AccesoAleatorio2 {

    public static void main(String[] args) {
        File archivo = new File("./Archivos/Primos2.txt");
        //int primo;
        RandomAccessFile raf = null;
        BufferedReader br = null;
        String prueba= "user.dir";

        try {
            if (archivo.exists()) {
                archivo.delete();
            } else {
                archivo.createNewFile();
                System.out.println("Primos.txt creado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            raf = new RandomAccessFile(archivo, "rw");
            for (int i = 0; i < 100; i++) {
                if(i%2!=0){
                    //primo=i;
                    raf.writeInt(i);
                }
                
            }
            if(raf!=null){
                raf.close();
            }
            br=new BufferedReader(new FileReader(archivo));
            br.close();
            System.out.println(System.getProperty(prueba));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
