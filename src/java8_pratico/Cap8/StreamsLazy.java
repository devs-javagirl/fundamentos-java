package java8_pratico.Cap8;

import java8_pratico.Cap6.Usuario2;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsLazy {
    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios.add(new Usuario2("Ana", 10));
        usuarios.add(new Usuario2("Bruno", 180));
        usuarios.add(new Usuario2("Carlos", 150));
        usuarios.add(new Usuario2("Alice", 90));
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

//        usuarios.stream()
//                .filter(u -> u.getPontos() > 100)
//                .sorted(Comparator.comparing(Usuario2::getNome));
//
//        List<Usuario2> filtradosOrdenados = usuarios.stream()
//                .filter(u -> u.getPontos() > 100)
//                .sorted(Comparator.comparing(Usuario2::getNome))
//                .collect(Collectors.toList());
//
//        filtradosOrdenados.forEach(System.out::println);

        System.out.println("----------------------------------------");

//        Usuario2 maisDe100 = usuarios.stream()
//                .filter(u -> u.getPontos() > 100)
//                .collect(Collectors.toList())
//                .get(0);
//
//        System.out.println(maisDe100.toString());

        System.out.println("----------------------------------------");
        Optional<Usuario2> usuarioOptional = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .findAny();

        System.out.println(usuarioOptional.toString());

    }
}
