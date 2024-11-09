package maquina_snacks_archivos.servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import maquina_snacks_archivos.dominio.Snack;

public class ServicioSnacksArchivos implements IServicioSnacks {
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    // Crear lista
    private List<Snack> snacks = new ArrayList<>();

    // constructior
    public ServicioSnacksArchivos() {
        // Creamos Archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try {
            existe = archivo.exists();
            if (existe) {
                this.snacks = obtenerSnacks();
            } else { // Creamos archivo
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se a creado el archivo");
            }
        } catch (Exception e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
        // Si no existe, cargamos Snacks por defecto
        if (!existe) {
            cargarSnacksIniciales();
        }
    }

    private void cargarSnacksIniciales() {
        this.agregarSnack(new Snack("Papas", 70));
        this.agregarSnack(new Snack("Refresco", 50));
        this.agregarSnack(new Snack("Sandwich", 120));
    }

    private List<Snack> obtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String linea : lineas) {
                String[] lineaSnack = linea.split(",");
                var idSnack = lineaSnack[0]; // No se usa
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombre, precio);
                snacks.add(snack); // Agregamos el Snack leido a la lista
            }
        } catch (Exception e) {
            System.out.println("Error al leer archivo de Snacks: " + e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }

    @Override
    public void agregarSnack(Snack snack) {
        // 1 Agregamos nuevo Snack
        this.snacks.add(snack);
        // 2 Guardamos el snack en un archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close();
        } catch (Exception e) {
            System.out.println("Error al agregar Snack: " + e.getMessage());
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- Snaks en el inventario ---");
        // Mostramos la lista desde el archivo
        var invetarioSnacks = "";
        for (var snack : this.snacks) {
            invetarioSnacks += snack.toString() + "\n";
        }
        System.out.println(invetarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }

}
