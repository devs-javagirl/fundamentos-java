package Cap6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsuarioModeradorUsuario {
    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios.add(new Usuario2("Carlos", 150));
        usuarios.add(new Usuario2("Ana", 200));
        usuarios.add(new Usuario2("Bruno", 180));

        usuarios.forEach(usuario -> {
            if (usuario.getNome().startsWith("A")) {
                usuario.tornaModerador();
            } else {
                usuario.tornaUsuario();
            }
        });

        // Exibindo os usuários ordenados
        System.out.println("Usuários: ");
        usuarios.forEach(System.out::println);
    }
}
