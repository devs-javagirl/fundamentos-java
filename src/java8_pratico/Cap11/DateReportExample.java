package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateReportExample {

    public static void main(String[] args) {

        // 1. Criação dos dados de exemplo com datas
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilherme Silveira");
        Customer paulo = new Customer("Paulo Silveira");
        Customer adriano = new Customer("Adriano Almeida");

        Product livro = new Product("Livro", new BigDecimal("100"));
        Product tablet = new Product("Tablet", new BigDecimal("400"));
        Product celular = new Product("Celular", new BigDecimal("250"));
        Product notebook = new Product("Notebook", new BigDecimal("500"));

        // Pagamentos com datas diferentes para demonstração
        List<Payment3> payments = Arrays.asList(
                new Payment3(rodrigo, Arrays.asList(livro, tablet), LocalDateTime.of(2023, 1, 15, 10, 0)),
                new Payment3(guilherme, Arrays.asList(livro, celular), LocalDateTime.of(2023, 1, 20, 14, 30)),
                new Payment3(paulo, Arrays.asList(tablet, celular, livro), LocalDateTime.of(2023, 2, 5, 9, 15)),
                new Payment3(paulo, Arrays.asList(livro, celular), LocalDateTime.of(2023, 2, 10, 11, 45)),
                new Payment3(adriano, Arrays.asList(notebook, livro), LocalDateTime.of(2023, 3, 1, 16, 20)),
                new Payment3(rodrigo, Arrays.asList(tablet), LocalDateTime.of(2023, 3, 15, 13, 10)),
                new Payment3(guilherme, Arrays.asList(notebook), LocalDateTime.of(2023, 3, 20, 15, 30))
        );

        // 2. Agrupamento por mês/ano (YearMonth)
        Map<YearMonth, List<Payment3>> paymentsPerMonth = payments.stream()
                .collect(Collectors.groupingBy(p -> YearMonth.from(p.getDate())));

        System.out.println("\nPagamentos agrupados por mês:");
        paymentsPerMonth.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.println("\nMês/Ano: " + entry.getKey());
                    entry.getValue().forEach(payment ->
                            System.out.println("  " + payment.getCustomer().getName() +
                                    " - R$" + payment.getTotalAmount()));
                });

        // 3. Valor total faturado por mês/ano
        Map<YearMonth, BigDecimal> paymentsValuePerMonth = payments.stream()
                .collect(Collectors.groupingBy(
                        p -> YearMonth.from(p.getDate()),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Payment3::getTotalAmount,
                                BigDecimal::add
                        )
                ));

        System.out.println("\nValor total faturado por mês:");
        paymentsValuePerMonth.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": R$" + entry.getValue()));

        // 4. Número de pagamentos por mês
        Map<YearMonth, Long> paymentsCountPerMonth = payments.stream()
                .collect(Collectors.groupingBy(
                        p -> YearMonth.from(p.getDate()),
                        Collectors.counting()
                ));

        System.out.println("\nNúmero de pagamentos por mês:");
        paymentsCountPerMonth.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " pagamentos"));
    }
}

// Classes auxiliares com adição de data
class Payment3 {
    private Customer customer;
    private List<Product> products;
    private LocalDateTime date;

    public Payment3(Customer customer, List<Product> products, LocalDateTime date) {
        this.customer = customer;
        this.products = products;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getTotalAmount() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
