package Cap8;

import Cap6.Usuario2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Reducao {
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

        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .average()
                .getAsDouble();

        System.out.println("Media: " + pontuacaoMedia);

        System.out.println("----------------------------------------");

        Optional<Usuario2> max = usuarios.stream()
                .max(Comparator.comparing(Usuario2::getPontos));
        Usuario2 maximaPontuacao = max.get();

        System.out.println("maximaPontuacao: " + maximaPontuacao);

        System.out.println("----------------------------------------");

        int total = usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .sum();

        System.out.println("total sum: " + total);

        System.out.println("----------------------------------------");

        int total1 = usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .reduce(0, (a, b) -> a + b);

        System.out.println("total1 (reduce): " + total1);

        System.out.println("----------------------------------------");

        int total2 = usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .reduce(0, Integer::sum);

        System.out.println("total2 (Integer::sum): " + total2);

        System.out.println("----------------------------------------");

        int multiplicacao = usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .reduce(1, (a, b) -> a * b);

        System.out.println("multiplicacao: " + multiplicacao);

        System.out.println("----------------------------------------");

        int total3 = usuarios.stream()
                .reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);

        System.out.println("total3 (reduce): " + total3);

        System.out.println("----------------------------------------");



    }
}
