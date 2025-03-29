package java8_pratico.Cap5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class ImportEstatico {
    public static void main(String[] args) {
        List<Usuario1> usuarios = new ArrayList<>();
        usuarios.add(new Usuario1("Carlos", 150));
        usuarios.add(new Usuario1("Ana", 200));
        usuarios.add(new Usuario1("Bruno", 180));

        Function<Usuario1, String> byName = Usuario1::getNome;
        usuarios.sort(comparing(byName));

        // Exibindo os usuários ordenados
        System.out.println("Usuários ordenados pelo nome:");
        usuarios.forEach(System.out::println);
    }
}
