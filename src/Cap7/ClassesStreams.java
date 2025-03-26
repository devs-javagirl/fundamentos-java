package Cap7;

import Cap6.Usuario2;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class ClassesStreams {

    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        //usuarios.add(new Usuario2("Carlos", null));
        //usuarios.add(new Usuario2("Ana", null));
        //usuarios.add(new Usuario2("Alice", null));

        /*
        IntStream stream = usuarios.stream()
                .mapToInt(Usuario2::getPontos);
        stream.forEach(System.out::println);

        IntStream stream2 = usuarios.stream()
                .mapToInt(Usuario2::getPontos);
        System.out.println("Soma dos pontos: " + stream2.sum());

        double pontuacaoMedia = usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .average()
                .getAsDouble();
        System.out.println("Pontua��o m�dia: " + pontuacaoMedia);


        OptionalDouble media = usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .average();
        double pontuacaoMedia2 = media.orElse(0.0);
        System.out.println("Pontua��o m�dia: " + pontuacaoMedia2);
           */

        try {
            double pontuacaoMedia = usuarios.stream()
                    .mapToInt(Usuario2::getPontos)
                    .average()
                    .orElse(0.0);
                    //.orElseThrow(() -> new IllegalStateException("N�o foi poss�vel calcular a pontua��o m�dia. Lista de usu�rios est� vazia."));
            System.out.println("Pontua��o m�dia: " + pontuacaoMedia);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        /*
        usuarios.stream()
                .mapToInt(Usuario2::getPontos)
                .average()
                .ifPresent(valor -> janela.atualiza(valor));
         */

    }
}
