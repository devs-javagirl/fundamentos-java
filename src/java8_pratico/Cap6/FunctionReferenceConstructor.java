package java8_pratico.Cap6;

import java.util.function.Function;

public class FunctionReferenceConstructor {
    public static void main(String[] args) {
        Function<String,Usuario2> criadorDeUsuarios = Usuario2::new;
        Usuario2 rodrigo = criadorDeUsuarios.apply("Rodrigo Turini");
        Usuario2 paulo = criadorDeUsuarios.apply("Paulo Silveira");
        System.out.println(rodrigo);
    }
}
