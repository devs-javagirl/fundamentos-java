package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioPagamentosPorData {

    public static void main(String[] args) {
        // Criando alguns produtos
        Product livro = new Product("Livro Java 8", new BigDecimal("99.90"));
        Product curso = new Product("Curso Stream API", new BigDecimal("299.90"));
        Product notebook = new Product("Notebook", new BigDecimal("4999.90"));

        // Criando pagamentos com datas diferentes
        List<Payment> payments = Arrays.asList(
                new Payment(
                        Arrays.asList(livro, curso),
                        LocalDateTime.of(2023, 1, 15, 10, 30)
                ),
                new Payment(
                        Arrays.asList(livro),
                        LocalDateTime.of(2023, 1, 20, 14, 15)
                ),
                new Payment(
                        Arrays.asList(notebook),
                        LocalDateTime.of(2023, 2, 5, 9, 0)
                ),
                new Payment(
                        Arrays.asList(curso, curso),
                        LocalDateTime.of(2023, 2, 28, 16, 45)
                )
        );

        // 1. Agrupando pagamentos por mês/ano (YearMonth)
        Map<YearMonth, List<Payment>> paymentsPerMonth = payments.stream()
                .collect(Collectors.groupingBy(
                        p -> YearMonth.from(p.getDate())
                ));

        System.out.println("Pagamentos agrupados por mês:");
        paymentsPerMonth.forEach((month, pays) -> {
            System.out.println(month + ": " + pays.size() + " pagamento(s)");
        });

        // 2. Calculando faturamento mensal
        Map<YearMonth, BigDecimal> paymentsValuePerMonth = payments.stream()
                .collect(Collectors.groupingBy(
                        p -> YearMonth.from(p.getDate()),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                p -> p.getProducts().stream()
                                        .map(Product::getPrice)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add),
                                BigDecimal::add
                        )
                ));

        System.out.println("\nFaturamento por mês:");
        paymentsValuePerMonth.forEach((month, total) -> {
            System.out.println(month + ": R$ " + total);
        });
    }

}
