public class ArgumentosVariables {
    public static void main(String[] args) {
        // imprimirNueros(1, 2, 3, 4, 5, 6);
        variosParametros("karla", 10, 20, 30);
    }

    static void variosParametros(String nombre, int... numeros) {
        System.out.println(nombre);
        imprimirNueros(numeros);
    }

    static void imprimirNueros(int... numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }

}
