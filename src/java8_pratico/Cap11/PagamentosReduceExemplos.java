package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.Month;
import java.nio.file.Paths;

public class PagamentosReduceExemplos {

    public static void main(String[] args) {
        // Dados simulados (iguais aos da LojaDeDigitalGoodies2)
        Customer paulo = new Customer("Paulo Silveira");
        Customer rodrigo = new Customer("Rodrigo Turini");
        Customer guilherme = new Customer("Guilherme Silveira");
        Customer adriano = new Customer("Adriano Almeida");

        Product bach = new Product("Bach Completo", Paths.get("/music/bach.mp3"), new BigDecimal(100));
        Product poderosas = new Product("Poderosas Anita", Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
        Product bandeira = new Product("Bandeira Brasil", Paths.get("/images/brasil.jpg"), new BigDecimal(50));
        Product beauty = new Product("Beleza Americana", Paths.get("/movies/beauty.mov"), new BigDecimal(150));
        Product vingadores = new Product("Os Vingadores", Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
        Product amelie = new Product("Amelie Poulain", Paths.get("/movies/amelie.mov"), new BigDecimal(100));

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

        // Gerar subtotais (stream de BigDecimal):
        Stream<BigDecimal> subtotais = payments.stream()
                .map(p -> p.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));

        System.out.println("Subtotais por pagamento:");
        subtotais.forEach(System.out::println);

        // Agora vamos somar todos os subtotais:
        BigDecimal totalGeral = payments.stream()
                .map(p -> p.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nTotal geral de todos os pagamentos: " + totalGeral);

        // Criar um único stream de todos os preços (flatMap):
        Stream<BigDecimal> todosOsPrecos = payments.stream()
                .flatMap(p -> p.getProducts().stream()
                        .map(Product::getPrice));

        System.out.println("\nTodos os preços de produtos:");
        todosOsPrecos.forEach(System.out::println);

        // Usando Function<Payment, Stream<BigDecimal>>
        Function<Payment, Stream<BigDecimal>> mapper =
                p -> p.getProducts().stream().map(Product::getPrice);

        System.out.println("\nUsando Function<Payment, Stream<BigDecimal>>:");
        payments.stream()
                .flatMap(mapper)
                .forEach(System.out::println);


    }
}
