package Cap7;

import Cap5.Exemplo1;
import Cap6.Usuario2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MantemOriginal {
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

        //Exemplo1
       // usuarios.stream()
        //        .filter(u -> u.getPontos() > 100);
       // System.out.println("Usuários: ");
       // usuarios.forEach(System.out::println); // Exibe todos os usuários

        //Exemplo2
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .forEach(System.out::println);

        System.out.println("--Lista original------------------");
        usuarios.forEach(System.out::println); // Exibe todos os usuários

    }
}
