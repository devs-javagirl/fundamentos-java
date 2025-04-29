package java8_pratico.Cap12;

import java.util.function.Supplier;
import java.security.PrivilegedAction;

public class ExemploInferenciaTipos {

    private void execute(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

    public void exemploCorretoComSupplier() {
        Supplier<String> supplier = () -> "executando um supplier";
        execute(supplier);
    }

    public void exemploErroComPrivilegedAction() {
        PrivilegedAction<String> action = () -> "executando uma a��o";
        // execute(action); // N�o compila
    }

    public void exemploCorretoComPrivilegedAction() {
        PrivilegedAction<String> action = () -> "executando uma a��o";
        execute(action::run); // Corrige usando refer�ncia de m�todo
    }

    public static void main(String[] args) {
        ExemploInferenciaTipos exemplo = new ExemploInferenciaTipos();
        exemplo.exemploCorretoComSupplier();
        exemplo.exemploCorretoComPrivilegedAction();
    }
}
