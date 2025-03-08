package Cap5;

public class Exemplo1 {

    interface A {
        default void metodo() {
            System.out.println("M�todo de A");
        }
    }

    interface B {
        default void metodo() {
            System.out.println("M�todo de B");
        }
    }

    class C implements A, B {
        @Override
        public void metodo() {
            A.super.metodo(); // Ou B.super.metodo()
        }
    }
}
