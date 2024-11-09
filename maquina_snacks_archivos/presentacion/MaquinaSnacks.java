package maquina_snacks_archivos.presentacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import maquina_snacks_archivos.dominio.Snack;
import maquina_snacks_archivos.servicio.IServicioSnacks;
import maquina_snacks_archivos.servicio.ServicioSnacksArchivos;
// import maquina_snacks_archivos.servicio.ServicioSnacksLista;

public class MaquinaSnacks {

    public static void main(String[] args) {
        maquinaSnacks();
    }

    private static void maquinaSnacks() {
        var salir = false;
        var console = new Scanner(System.in);
        // creamos objeto
        // IServicioSnacks servicioSnacks = new ServicioSnacksLista();
        IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();
        // Creamos lista
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snacks ***");
        servicioSnacks.mostrarSnacks(); // Mostramos inventario de snacks disponibles
        while (!salir) {
            try {
                var opcion = mostrarMenu(console);
                salir = ejecutarOpciones(opcion, console, productos, servicioSnacks);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e);
            } finally {
                System.out.println();
            }

        }

    }

    private static int mostrarMenu(Scanner console) {
        System.out.print("""
                Menu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar nuevo snack
                4. Inventario Snacks
                5. Salir
                Elige una opcion:\s""");

        // leemos y retornamos la opcion seleccionada
        return Integer.parseInt(console.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner console, List<Snack> productos,
            IServicioSnacks servicioSnacks) {
        var salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(console, productos, servicioSnacks);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(console, servicioSnacks);
            case 4 -> listarInvetarioSnacks(console, servicioSnacks);
            case 5 -> {
                System.out.print("Regresa pronto!");
                salir = true;
            }
            default -> System.out.println("Opcion invalida: " + opcion);
        }
        return salir;
    }

    private static void listarInvetarioSnacks(Scanner console, IServicioSnacks servicioSnacks) {
        servicioSnacks.mostrarSnacks();
    }

    private static void comprarSnack(Scanner console, List<Snack> productos, IServicioSnacks servicioSnacks) {
        System.out.print("Que snack quieres comprar (id)? ");
        var idSnack = Integer.parseInt(console.nextLine());
        // validar que el snack exista
        var snackEncontrado = false;
        for (var snack : servicioSnacks.getSnacks()) {
            if (idSnack == snack.getIdSnack()) {
                // agregamos snack
                productos.add(snack);
                System.out.println("ok, snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }

        if (!snackEncontrado) {
            System.out.println("id de snack no encontrado: " + idSnack);
        }

    }

    private static void mostrarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de Venta ***";
        var total = 0.0;
        for (var producto : productos) {
            ticket += "\n\t- " + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);

    }

    private static void agregarSnack(Scanner console, IServicioSnacks servicioSnacks) {
        System.out.print("Nombre del snack: ");
        var nombre = console.nextLine();
        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(console.nextLine());
        servicioSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu snack se a agregado correctamente");
        servicioSnacks.mostrarSnacks();
    }

}
