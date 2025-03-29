package java8_pratico.Cap7;

import java8_pratico.Cap6.Usuario2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectorsDemo {

    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios.add(new Usuario2("Carlos", 150));
        usuarios.add(new Usuario2("Ana", 10));
        usuarios.add(new Usuario2("Alice", 90));

          /*
        Supplier<ArrayList<Usuario2>> supplier = ArrayList::new;
        BiConsumer<ArrayList<Usuario2>, Usuario2> accumulator =
                ArrayList::add;
        BiConsumer<ArrayList<Usuario2>, ArrayList<Usuario2>> combiner =
                ArrayList::addAll;

        List<Usuario2> maisQue100 = usuarios.stream()
                .filter(u-> u.getPontos() > 100)
                .collect(supplier, accumulator, combiner);
        */

        List<Usuario2> maisQue100 = usuarios.stream()
                .filter(u-> u.getPontos() > 100)
                .collect(toList());
        maisQue100.forEach(System.out::println);


        Set<Usuario2> set = usuarios.stream().collect(
                Collectors.toCollection(HashSet::new));


    }
}
