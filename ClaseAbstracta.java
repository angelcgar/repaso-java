public class ClaseAbstracta {
    public static void main(String[] args) {

        // FiguraGeometrica figura = new FiguraGeometrica() {
        // };

        FiguraGeometrica figura = new Rectangulo();
        figura.dibujar();
    }
}

// abstracta

abstract class FiguraGeometrica {

    public abstract void dibujar();
}

class Rectangulo extends FiguraGeometrica {

    @Override
    public void dibujar() {
        System.out.println("hola dibujo");
    }

}
