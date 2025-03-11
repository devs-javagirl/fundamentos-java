package Cap5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SimplificandoComparacao {
    public static void main(String[] args) {
        List<Usuario1> usuarios = new ArrayList<>();
        usuarios.add(new Usuario1("Carlos", 150));
        usuarios.add(new Usuario1("Ana", 200));
        usuarios.add(new Usuario1("Bruno", 180));

        //exemplo1
        //usuarios.sort(Comparator.comparing(u -> u.getNome()));

        //exemplo2
        usuarios.sort(Comparator.comparing(Usuario1::getNome));

        // Exibindo os usuários ordenados
        System.out.println("Usuários ordenados pelo nome:");
        usuarios.forEach(System.out::println);
    }
}
