import java.util.HashMap;
import java.util.Map;

public class Mapa {
    public static void main(String[] args) {
        Map<String, String> persona = new HashMap<>();
        persona.put("nombre", "Diego");
        persona.put("apellido", "Flores");
        persona.put("edad", "39");
        persona.put("edad", "31");

        System.out.println("valores");
        persona.entrySet().forEach(System.out::println);

        persona.put("edad", "35");
        persona.remove("apellido");
        System.out.println("\nNuevos valores");

        persona.entrySet().forEach(System.out::println);

        // iterar sobre los elementos
        System.out.println("\niterando elementos");
        persona.forEach((llave, valor) -> {
            System.out.println(llave + " " + valor);
        });
    }
}
