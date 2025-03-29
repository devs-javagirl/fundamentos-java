package java8_pratico.Cap8;

import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimitiveInfinityStreamsTest {

    // Classe interna para gerar sequ�ncia de Fibonacci com IntSupplier
    static class Fibonacci implements IntSupplier {
        private int anterior = 0;
        private int proximo = 1;

        @Override
        public int getAsInt() {
            proximo = proximo + anterior;
            anterior = proximo - anterior;
            return anterior;
        }
    }

    public static void main(String[] args) {
        // Exemplo 1: Criando um IntStream com range
        System.out.println("IntStream.range(1, 5):");
        IntStream.range(1, 5).forEach(System.out::println);

        // Exemplo 2: Stream infinito de n�meros aleat�rios
        System.out.println("\nStream infinito de n�meros aleat�rios (limitado a 5):");
        new Random().ints().limit(5).forEach(System.out::println);

        // Exemplo 3: Stream infinito de Fibonacci (primeiros 10 n�meros)
        System.out.println("\nPrimeiros 10 n�meros da sequ�ncia de Fibonacci:");
        IntStream.generate(new Fibonacci()).limit(10).forEach(System.out::println);

        // Exemplo 4: Encontrando o primeiro n�mero de Fibonacci maior que 100
        int maiorQue100 = IntStream.generate(new Fibonacci())
                .filter(f -> f > 100)
                .findFirst()
                .getAsInt();
        System.out.println("\nPrimeiro n�mero de Fibonacci maior que 100: " + maiorQue100);

        // Exemplo 5: Criando uma lista com os 10 primeiros n�meros naturais
        List<Integer> numerosNaturais = IntStream.iterate(0, x -> x + 1)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("\nLista dos 10 primeiros n�meros naturais: " + numerosNaturais);

        // Exemplo 6: Verificando se todos os n�meros de Fibonacci s�o pares (allMatch)
        boolean todosPares = IntStream.generate(new Fibonacci())
                .limit(10)
                .allMatch(f -> f % 2 == 0);
        System.out.println("\nTodos os primeiros 10 n�meros de Fibonacci s�o pares? " + todosPares);
    }
}

