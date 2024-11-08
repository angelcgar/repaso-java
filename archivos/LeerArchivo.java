package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo {

    public static void main(String[] args) {
        // leer archivo
        var nombreArchivo = "miArchivo.txt";
        var archivo = new File(nombreArchivo);
        try {
            System.out.println("Contenido del archivo: ");
            // Abrir archivo
            var entrada = new BufferedReader(new FileReader(archivo));
            // leermos linea a linea
            var linea = entrada.readLine();
            // Leer todas la lineas
            while (linea != null) {
                System.out.println(linea);
                // Terminamos de leer la linea
                linea = entrada.readLine();
            }
            // Cerrar archivo
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error al leer archivo: " + e);
        }
    }
}
