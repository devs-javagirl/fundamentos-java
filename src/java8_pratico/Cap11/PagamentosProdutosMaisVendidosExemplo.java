package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PagamentosProdutosMaisVendidosExemplo {
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
                        LocalDateTime.of(2014, Month.FEBRUARY, 16, 14, 0),
                        guilherme),

                new Payment(Arrays.asList(bach, bandeira, amelie),
                        LocalDateTime.of(2014, Month.MARCH, 15, 10, 30),
                        rodrigo),

                new Payment(Arrays.asList(beauty, amelie),
                        LocalDateTime.of(2014, Month.MARCH, 15, 15, 0),
                        paulo),

                new Payment(Arrays.asList(bach, poderosas),
                        LocalDateTime.of(2014, Month.MARCH, 16, 9, 0),
                        paulo),

                new Payment(Arrays.asList(beauty, vingadores, bach),
                        LocalDateTime.of(2014, Month.MARCH, 16, 18, 0),
                        adriano)
        );

        // Criar um Stream a partir de List:
        Stream<Product> productsStream1 = payments.stream()
                .map(Payment::getProducts)
                .flatMap(p -> p.stream());

        System.out.println("productsStream1:");
        productsStream1.forEach(System.out::println);
        System.out.println("---------------");

        // Alternativa com method reference:
        Stream<Product> productsStream2 = payments.stream()
                .map(Payment::getProducts)
                .flatMap(List::stream);

        System.out.println("productsStream2:");
        productsStream2.forEach(System.out::println);
        System.out.println("---------------");

        // Forma ainda mais enxuta:
        Stream<Product> products = payments.stream()
                .flatMap(p -> p.getProducts().stream());

        System.out.println("products:");
        products.forEach(System.out::println);
        System.out.println("---------------");

        // Contagem de cada produto:
        Map<Product, Long> topProducts = payments.stream()
                .flatMap(p -> p.getProducts().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Impressão do Map:
        System.out.println("Contagem dos produtos:");
        System.out.println(topProducts);

        // Melhor: imprimir cada entrada em linha separada:
        System.out.println("\nProdutos e suas quantidades:");
        topProducts.entrySet().stream()
                .forEach(System.out::println);

        // Usar max com Comparator baseado no valor:
        System.out.println("\nProduto mais vendido:");
        topProducts.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);
    }
}
