package java8_pratico.Cap6;

import java.util.function.Supplier;

public class SupplierReferenceContructor {
    public static void main(String[] args) {

        Supplier<Usuario2> criadorDeUsuarios = Usuario2::new;
        Usuario2 novo = criadorDeUsuarios.get();
        novo.setNome("Paulo Silveira");
        novo.setPontos(100);
        System.out.println(novo);

    }
}
