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
 * @fecha 21-abr-2019 16:29:45
 * @author SantiPG
 */
import java.util.*;
import java.io.*;

public class Ejercicio3ver2 {

    public static void main(String[] args) throws IOException {
        File fichero1, fichero2;
        String texto, linea;
        int longitud;

        fichero1 = new File("C:\\Users\\Santi\\Desktop\\Archivo1.txt");
        fichero2 = new File("C:\\Users\\Santi\\Desktop\\Resultado.txt");

        try {
            if (fichero1.exists()) {
                System.out.println("El fichero1 ya está creado");
            } else {
                fichero1.createNewFile();
                System.out.println("Archivo1.txt creado");
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("Fichero no encontrado");
            fnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            if (fichero2.exists()){
                System.out.println("El fichero resultado ya existe");
            }else {
                fichero2.createNewFile();
                System.out.println("Resultado.txt creado");
            }
        }catch (FileNotFoundException fnf){
            System.out.println("Fichero no encontrado");
            fnf.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero1));
        texto = "Texto \nde \nprueba \nque \nescribimos \nen \nfichero1 \na \nespera \n"
                + "de \nver \nlas \npalabras \nde \nque \nlongitud \nse \ncopian \n"
                + "al \narchivo \nresultado";
        
        try{
            bw.write(texto);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally{
            if (bw != null){
                bw.close();
            }
        }
        System.out.println("Cuantos caracteres?");
        Scanner lector = new Scanner(System.in);
        try{
            longitud = lector.nextInt();
        }catch (InputMismatchException e){
            e.getMessage();
            System.out.println("Valor no válido, se asingna 3 a la variable longitud");
            longitud = 3;
        }
        
        BufferedReader br = null;
        BufferedWriter bwr = null;
        
        try{
            br = new BufferedReader(new FileReader(fichero1));
            bwr = new BufferedWriter(new FileWriter(fichero2));
            
            linea= br.readLine();
            
            while (linea!=null){
                if (linea.length()<=(longitud+1)){
                    bwr.write(linea);                    
                }
                linea = br.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally{
            if (br !=null){
                br.close();
            }
            if (bwr != null){
                bwr.close();
            }
                
        }

    }

}
