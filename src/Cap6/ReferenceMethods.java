package Cap6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ReferenceMethods {
    public static void main(String[] args) {
        //exemplo1();
        //exemplo2();

        Usuario2 user1 = new Usuario2("Paulo Silveira", 150);
        Usuario2 user2 = new Usuario2("Rodrigo Turini", 120);
        Usuario2 user3 = new Usuario2("Guilherme Silveira", 190);

        List<Usuario2> usuarios = Arrays.asList(user1, user2, user3);

        usuarios.forEach(u -> u.tornaModerador());
        usuarios.forEach(System.out::println);

        /*
        //FORMA ANTIGA DE FAZER:
        for (Usuario2 usuario : usuarios) {
            System.out.println(usuario.toString());
        }
        */
    }

    private static void exemplo2() {
        Usuario2 gisele = new Usuario2("Gisele Lala", 50);
        Consumer<Usuario2> consumer = Usuario2::tornaModerador;
        //Runnable consumer2 = Usuario2::tornaModerador; // Erro de compilação!
        consumer.accept(gisele); // Invoca gisele.tornaModerador()
        System.out.println(gisele);
    }

    private static void exemplo1() {
        Usuario2 rodrigo = new Usuario2("Rodrigo Turini", 50);
        Runnable bloco = rodrigo::tornaModerador;
        bloco.run(); // Equivalente a rodrigo.tornaModerador()
        System.out.println(rodrigo);
    }
}
