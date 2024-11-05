public interface Traductor {
    public abstract void traducir();

    public default void iniciarTraductor() {
        System.out.println("Iniciando traductor...");
    };
}

class Ingles implements Traductor {

    @Override
    public void traducir() {
        System.out.println("Traduciendo");
    }

}

class Frances implements Traductor {

    @Override
    public void traducir() {
        System.out.println("Traduciendo frances");
    }

}

class PruebaTraductor {
    public static void main(String[] args) {
        System.out.println("PruebaTraductor.main()");
        Traductor ingles = new Ingles();
        ingles.iniciarTraductor();
        ingles.traducir();

        System.out.println();
        Traductor frances = new Frances();
        frances.iniciarTraductor();
        frances.traducir();
    }
}
