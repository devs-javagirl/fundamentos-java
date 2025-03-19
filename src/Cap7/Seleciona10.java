package Cap7;

import Cap6.Usuario1;
import Cap6.Usuario2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Seleciona10 {
    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios.add(new Usuario2("Carlos", 150));
        usuarios.add(new Usuario2("Ana", 200));
        usuarios.add(new Usuario2("Alice", 90));
        usuarios.add(new Usuario2("Bruno", 180));
        usuarios.add(new Usuario2("Manuela", 300));
        usuarios.add(new Usuario2("Luiza", 320));
        usuarios.add(new Usuario2("Luis", 210));
        usuarios.add(new Usuario2("Daniela", 321));
        usuarios.add(new Usuario2("Eduardo", 478));
        usuarios.add(new Usuario2("Fernanda", 150));

        usuarios.add(new Usuario2("Gabriel", 62));
        usuarios.add(new Usuario2("Helena", 500));
        usuarios.add(new Usuario2("Igor", 275));
        usuarios.add(new Usuario2("Juliana", 120));

        usuarios.sort(Comparator.comparing(Usuario2::getPontos).reversed());

        usuarios.subList(0,10)
                .forEach(Usuario2::tornaModerador);

        System.out.println("Usuários: ");
        usuarios.forEach(System.out::println);
    }
}
