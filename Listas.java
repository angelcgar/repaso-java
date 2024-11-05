import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();

        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");
        miLista.add("Domingo");

        // for (String elementos : miLista) {
        // System.out.println(elementos);
        // }

        // lambda
        // miLista.forEach(elemento -> Console.log("elemento = " + elemento)); // XD
        // miLista.forEach(elemento -> System.out.println("elemento = " + elemento));

        miLista.forEach(System.out::println);
        System.out.println();

        List<String> nombres = Arrays.asList("pedro", "nohemi");
        nombres.forEach(System.out::println);

    }

}
