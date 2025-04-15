package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProdutosPorClienteExemplo {
    public static void main(String[] args) {
        // Criando clientes
        Customer paulo = new Customer("Paulo Silveira");
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilherme Silveira");
        Customer adriano = new Customer("Adriano Almeida");

        // Criando produtos
        Product bach = new Product("Bach Completo", Paths.get("/music/bach.mp3"), new BigDecimal(100));
        Product poderosas = new Product("Poderosas Anita", Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
        Product bandeira = new Product("Bandeira Brasil", Paths.get("/images/brasil.jpg"), new BigDecimal(50));
        Product beauty = new Product("Beleza Americana", Paths.get("/movies/beauty.mov"), new BigDecimal(150));
        Product vingadores = new Product("Os Vingadores", Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
        Product amelie = new Product("Amelie Poulain", Paths.get("/movies/amelie.mov"), new BigDecimal(100));

        // Criando pagamentos
        List<Payment> payments = Arrays.asList(
                new Payment(Arrays.asList(bach, poderosas, amelie),
                        LocalDateTime.of(2014, Month.FEBRUARY, 16, 14, 0), guilherme),

                new Payment(Arrays.asList(bach, bandeira, amelie),
                        LocalDateTime.of(2014, Month.MARCH, 15, 10, 30), rodrigo),

                new Payment(Arrays.asList(beauty, amelie),
                        LocalDateTime.of(2014, Month.MARCH, 15, 15, 0), paulo),

                new Payment(Arrays.asList(bach, poderosas),
                        LocalDateTime.of(2014, Month.MARCH, 16, 9, 0), paulo),

                new Payment(Arrays.asList(beauty, vingadores, bach),
                        LocalDateTime.of(2014, Month.MARCH, 16, 18, 0), adriano)
        );

        // 1. Agrupando pagamentos por cliente
        Map<Customer, List<Payment>> customerToPayments = payments.stream()
                .collect(Collectors.groupingBy(Payment::getCustomer));

        System.out.println("Pagamentos por cliente:");
        customerToPayments.forEach((c, list) ->
                System.out.println(c + ": " + list));

        // 2. Resultado intermediário: List<List<Product>> por cliente
        Map<Customer, List<List<Product>>> customerToProductsList = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getCustomer,
                        Collectors.mapping(Payment::getProducts, Collectors.toList())
                ));

        System.out.println("\nListas de produtos (aninhadas):");
        customerToProductsList.forEach((c, lists) ->
                System.out.println(c + ": " + lists));

        // 3. Achatar as listas em List<Product> por cliente (em dois passos)
        Map<Customer, List<Product>> customerToProducts2steps = customerToProductsList.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList())
                ));

        System.out.println("\nProdutos por cliente (achatado - 2 passos):");
        customerToProducts2steps.forEach((c, list) ->
                System.out.println(c + ": " + list));

        // 4. Mesma ideia, mas em uma única etapa
        Map<Customer, List<Product>> customerToProducts1step = payments.stream()
                .collect(Collectors.groupingBy(Payment::getCustomer,
                        Collectors.mapping(Payment::getProducts, Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList())
                ));

        System.out.println("\nProdutos por cliente (1 etapa):");
        customerToProducts1step.forEach((c, list) ->
                System.out.println(c + ": " + list));

        // 5. Usando reducing para acumular listas de produtos
        Map<Customer, List<Product>> customerToProductsReducing = payments.stream()
                .collect(Collectors.groupingBy(Payment::getCustomer,
                        Collectors.reducing(
                                Collections.emptyList(),
                                Payment::getProducts,
                                (l1, l2) -> {
                                    List<Product> l = new ArrayList<>();
                                    l.addAll(l1);
                                    l.addAll(l2);
                                    return l;
                                }
                        )
                ));

        System.out.println("\nProdutos por cliente (reducing):");
        customerToProductsReducing.forEach((c, list) ->
                System.out.println(c + ": " + list));
    }
}
