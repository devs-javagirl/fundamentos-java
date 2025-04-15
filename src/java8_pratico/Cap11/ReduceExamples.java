package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExamples {
    public static void main(String[] args) {
        // Lista de preços (exemplo genérico)
        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("19.90"),
                new BigDecimal("35.50"),
                new BigDecimal("10.00"),
                new BigDecimal("8.60")
        );

        // 1. Usando expressão lambda:
        Optional<BigDecimal> total1 = prices.stream()
                .reduce((total, price) -> total.add(price));

        total1.ifPresent(t -> System.out.println("Total com lambda: " + t));

        // 2. Usando method reference:
        Optional<BigDecimal> total2 = prices.stream()
                .reduce(BigDecimal::add);

        total2.ifPresent(t -> System.out.println("Total com method reference: " + t));

        // 3. Tratando retorno Optional com ifPresent:
        prices.stream()
                .reduce(BigDecimal::add)
                .ifPresent(result -> System.out.println("Total usando ifPresent: " + result));

        // 4. Evitando Optional (com valor identidade):
        BigDecimal total3 = prices.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total direto sem Optional: " + total3);
    }
}
