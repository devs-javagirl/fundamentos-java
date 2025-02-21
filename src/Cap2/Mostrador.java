package Cap2;

import java.util.function.Consumer;

class Mostrador implements Consumer<Usuario> {
    public void accept(Usuario u) {
        System.out.println(u.getNome());
    }
}