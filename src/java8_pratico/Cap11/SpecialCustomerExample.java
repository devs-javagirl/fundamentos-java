package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SpecialCustomerExample {

    public static void main(String[] args) {
        // 1. Criação dos dados de exemplo
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilherme Silveira");
        Customer paulo = new Customer("Paulo Silveira");
        Customer adriano = new Customer("Adriano Almeida");

        Product livro = new Product("Livro", new BigDecimal("100"));
        Product tablet = new Product("Tablet", new BigDecimal("200"));
        Product celular = new Product("Celular", new BigDecimal("250"));
        Product notebook = new Product("Notebook", new BigDecimal("500"));

        List<Payment> payments = Arrays.asList(
                new Payment(rodrigo, Arrays.asList(livro, tablet)),
                new Payment(guilherme, Arrays.asList(livro, celular)),
                new Payment(paulo, Arrays.asList(tablet, celular, livro)), new Payment(paulo, Arrays.asList(livro, celular)),
                new Payment(adriano, Arrays.asList(notebook, livro))
        );


        // 2. Cálculo do total gasto por cliente (versão refatorada)
        Function<Payment, BigDecimal> paymentToTotal =
                p -> p.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<Customer, BigDecimal> totalValuePerCustomer1 = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCustomer,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                paymentToTotal, //Interface Function customizada
                                BigDecimal::add
                        )
                ));


        Map<Customer, BigDecimal> totalValuePerCustomer2 = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCustomer,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Payment::getTotalAmount,
                                BigDecimal::add
                        )
                ));

        // 3. Exibição ordenada
        System.out.println("Total gasto por cliente:");
        totalValuePerCustomer1.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> System.out.println(entry.getKey().getName() + "=" + entry.getValue()));

        System.out.println("Total gasto por cliente (versão refatorada):");
        totalValuePerCustomer2.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> System.out.println(entry.getKey().getName() + "=" + entry.getValue()));


        // outro criterio, total compras por cliente
        Map<Customer, Long> countPerCustomer = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCustomer,
                        Collectors.counting()
                ));

        System.out.println("Número de pagamentos por cliente:");
        countPerCustomer.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> System.out.println(entry.getKey().getName() + "=" + entry.getValue()));


        Map<Customer, Optional<Product>> mostExpensiveProduct = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCustomer,
                        Collectors.flatMapping(
                                p -> p.getProducts().stream(),
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))
                        )
                ));

        System.out.println("Produto mais caro por cliente:");
        mostExpensiveProduct.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().orElse(null), Comparator.comparing(Product::getPrice)))
                .forEach(entry -> System.out.println(entry.getKey().getName() + "=" + entry.getValue().orElse(null)));
    }

}
