package Cap6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UsuarioModerador {
    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios.add(new Usuario2("Carlos", 150));
        usuarios.add(new Usuario2("Ana", 200));
        usuarios.add(new Usuario2("Bruno", 180));

        Consumer<Usuario2> tornaModerador = Usuario2::tornaModerador;
//        usuarios.forEach(tornaModerador);

        usuarios.forEach(tornaModerador);

        // Exibindo os usuários ordenados
        System.out.println("Usuários ordenados pelo número de pontos:");
        usuarios.forEach(System.out::println);
    }
}
