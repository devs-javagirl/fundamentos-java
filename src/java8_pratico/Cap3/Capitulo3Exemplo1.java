package java8_pratico.Cap3;

public class Capitulo3Exemplo1 {

    @FunctionalInterface
    interface Validador<T> {
        boolean valida(T t);
    }

    public static void main(String[] args) {

        Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");

        System.out.println(validadorCEP.valida("04101-300"));
    }

}
