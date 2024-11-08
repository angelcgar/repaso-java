package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearArchivos {
    public static void main(String[] args) {
        var nombreArchivo = "miArchivo.txt";
        var archivo = new File(nombreArchivo);
        try {
            if (archivo.exists()) {
                System.out.println("Ya existe");
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                // Se guarda el archivo en disco duro
                salida.close();
                System.out.println("Se a creado");
            }
        } catch (IOException e) {
            System.out.println("Error crear archivo: " + e.getMessage());
        }
    }
}
