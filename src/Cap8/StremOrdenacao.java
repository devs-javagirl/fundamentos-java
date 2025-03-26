package Cap8;

import Cap6.Usuario2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StremOrdenacao {
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

//        usuarios.sort(Comparator.comparing(Usuario2::getNome));
//
//        System.out.println("Usuários ordenados por nome: ");
//        usuarios.forEach(System.out::println);

        System.out.println("----------------------------------------");
//        usuarios.stream()
//                .filter(u -> u.getPontos() > 100)
//                .sorted(Comparator.comparing(Usuario2::getNome));
//
//        usuarios.forEach(System.out::println);

        System.out.println("----------------------------------------");

        List<Usuario2> filtradosOrdenados = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario2::getNome))
                .collect(Collectors.toList());

        filtradosOrdenados.forEach(System.out::println);


    }
}
