package Cap7;

import Cap5.Usuario;
import Cap6.Usuario2;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FiltraModerador {
    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios.add(new Usuario2("Carlos", 150));
        usuarios.add(new Usuario2("Ana", 10));
        usuarios.add(new Usuario2("Alice", 90));
        usuarios.add(new Usuario2("Bruno", 180));
        usuarios.add(new Usuario2("Manuela", 300));
        usuarios.add(new Usuario2("Luiza", 320));
        usuarios.add(new Usuario2("Luis", 210));
        usuarios.add(new Usuario2("Daniela", 321));
        usuarios.add(new Usuario2("Eduardo", 478));
        usuarios.add(new Usuario2("Fernanda", 15));
        usuarios.add(new Usuario2("Gabriel", 62));
        usuarios.add(new Usuario2("Helena", 500));
        usuarios.add(new Usuario2("Igor", 275));
        usuarios.add(new Usuario2("Juliana", 120));

        System.out.println("----------------------------------------");
        System.out.println("Usuários inicial: ");
        usuarios.forEach(System.out::println);

        System.out.println("----------------------------------------");
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .forEach(Usuario2::tornaModerador);

        usuarios.stream()
                .filter(Usuario2::isModerador)
                .forEach(System.out::println);

        System.out.println("----------------------------------------");
        System.out.println("Usuários original: ");
        usuarios.forEach(System.out::println);



    }
}
