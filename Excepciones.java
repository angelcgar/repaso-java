public class Excepciones {
    public static void main(String[] args) {
        int valor1 = 10, valor2 = 0;
        try {
            var res = valor1 / valor2;
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
