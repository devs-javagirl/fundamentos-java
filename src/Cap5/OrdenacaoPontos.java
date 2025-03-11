package Cap5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class OrdenacaoPontos {
    public static void main(String[] args) {
        List<Usuario1> usuarios = new ArrayList<>();
        usuarios.add(new Usuario1("Carlos", 150));
        usuarios.add(new Usuario1("Ana", 200));
        usuarios.add(new Usuario1("Bruno", 180));

        //exemplo1
        // Criando a fun��o que extrai o nome do usu�rio
//        Function<Usuario1, Integer> extraiPontos = u -> u.getPontos();
//
//        // Criando o Comparator baseado na fun��o de extra��o
//        Comparator<Usuario1> comparator = Comparator.comparing(extraiPontos);
//
//        // Ordenando a lista de usu�rios pelo nome
//        usuarios.sort(comparator);


        //exemplo2
//        ToIntFunction<Usuario1> extraiPontos2 = u -> u.getPontos();
//        Comparator<Usuario1> comparator2 = Comparator.comparingInt(extraiPontos2);
//        usuarios.sort(comparator2);

        //exemplo 3
        usuarios.sort(Comparator.comparingInt(u -> u.getPontos()));


        // Exibindo os usu�rios ordenados
        System.out.println("Usu�rios ordenados pelo n�mero de pontos:");
        usuarios.forEach(System.out::println);
    }
}
