package java8_pratico.Cap5;
import java.util.Arrays;
import java.util.List;

public class UsuarioSortExemplo {

    public static void main(String[] args) {

        /*
        A introdução de lambdas no Java 8 simplificou a criação de Comparators,
        tornando o código mais enxuto e expressivo. A possibilidade de usar interfaces
        funcionais (como Comparator) com lambdas é um dos pilares da programação funcional
        no Java moderno.
         */

        List<Usuario> usuarios = Arrays.asList(
            new Usuario("Carlos"),
            new Usuario("Ana"),
            new Usuario("Bruno")
        );

        usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
        // Resultado: [Ana, Bruno, Carlos]

        usuarios.forEach(u -> System.out.println(u.getNome()));
    }



}


