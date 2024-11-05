package excepciones;

public class PruebaAritmetica {
    public static void main(String[] args) {
        try {
            var resul = Aritmetica.division(1, 1);
            System.out.println(resul);
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e);
        } finally {
            System.out.println("hola");
        }
    }
}
