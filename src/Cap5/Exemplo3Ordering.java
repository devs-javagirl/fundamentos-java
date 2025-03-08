package Cap5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exemplo3Ordering {
    public static void main(String[] args) {
        List<Usuario> usuarios = List.of(
            new Usuario("Carlos"),
            new Usuario("Ana"),
            new Usuario("Bruno")
        );

        //copy
        ArrayList<Usuario> usuariosCopy = new ArrayList<>(usuarios);
        /*
        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };
        Collections.sort(usuariosCopy, comparator);
        */

        Comparator<Usuario> comparator = Comparator.comparing(Usuario::getNome);
        Collections.sort(usuariosCopy, comparator);

        usuariosCopy.forEach(u -> System.out.println(u.getNome()));
    }
}
