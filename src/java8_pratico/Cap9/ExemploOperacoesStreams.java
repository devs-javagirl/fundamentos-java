package java8_pratico.Cap9;
import java.util.*;
import java.util.stream.*;

public class ExemploOperacoesStreams {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Exemplo 1: forEach vs forEachOrdered
        System.out.println("forEach (não ordenado):");
        numeros.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println("\nforEachOrdered (ordenado):");
        numeros.parallelStream().forEachOrdered(n -> System.out.print(n + " "));

        // Exemplo 2: findAny vs findFirst
        System.out.println("\nfindAny: " + numeros.parallelStream().findAny().get());
        System.out.println("findFirst: " + numeros.parallelStream().findFirst().get());

        // Exemplo 3: unordered
        Set<Integer> conjunto = new HashSet<>(numeros);
        System.out.println("\nStream unordered:");
        conjunto.parallelStream().unordered().map(x -> x + 1).forEach(System.out::println);

        // Exemplo 4: groupingBy vs groupingByConcurrent
        Map<Boolean, List<Integer>> normal = numeros.parallelStream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("groupingBy: " + normal);

        Map<Boolean, List<Integer>> concurrente = numeros.parallelStream()
                .collect(Collectors.groupingByConcurrent(n -> n % 2 == 0));
        System.out.println("groupingByConcurrent: " + concurrente);

        // Exemplo 5: somando com variável compartilhada (ERRO!)
        System.out.println("\nExemplo inseguro com variável compartilhada:");
        UnsafeParallelStreamUsage.run();
    }

    static class UnsafeParallelStreamUsage {
        private static long total = 0;

        public static void run() {
            total = 0;
            LongStream.range(0, 100_000)
                    .parallel()
                    .filter(x -> x % 2 == 0)
                    .forEach(n -> total += n); // não seguro!
            System.out.println("Resultado inseguro: " + total);
        }
    }
}
