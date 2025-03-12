package Cap6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class CompondoComparators {
    public static void main(String[] args) {
        List<Usuario1> usuarios = new ArrayList<>();
        usuarios.add(new Usuario1("Carlos", 150));
        usuarios.add(new Usuario1("Ana", 200));
       // usuarios.add(new Usuario1(null, 180));
        usuarios.add(new Usuario1("Bruno", 180));

        //1
        usuarios.sort(Comparator.comparingInt(Usuario1::getPontos));
        System.out.println("Usuários ordenados pelo nome:");
        usuarios.forEach(System.out::println);

        //2
//        Comparator<Usuario1> c = Comparator.comparingInt(Usuario1::getPontos)
//                .thenComparing(Usuario1::getNome);
//        usuarios.sort(c);
//        System.out.println("Usuários ordenados pelo nome:");
//        usuarios.forEach(System.out::println);

        //3
//        usuarios.sort(Comparator.comparing(
//                Usuario1::getNome, Comparator.nullsLast(String::compareTo))
//        );
       // usuarios.sort(Comparator.nullsLast(Comparator.comparing(Usuario1::getNome)));

        //4
//        usuarios.sort(Comparator.comparing(Usuario1::getPontos).reversed());
        // Exibindo os usuários ordenados
//        System.out.println("Usuários ordenados pelo nome:");
//        usuarios.forEach(System.out::println);
    }
}
