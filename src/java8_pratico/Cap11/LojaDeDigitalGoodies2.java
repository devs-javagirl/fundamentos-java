package java8_pratico.Cap11;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.math.BigDecimal;

// Classe principal da loja
public class LojaDeDigitalGoodies2 {

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

        // Criando pagamentos com datas específicas
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

        // Ordenando os pagamentos por data e imprimindo
        System.out.println("Pagamentos ordenados por data:\n");
        payments.stream().sorted(Comparator.comparing(Payment::getDate)).forEach(System.out::println);
        //ordenar por nome do customer
        System.out.println("\nPagamentos ordenados por nome do cliente:\n");
        payments.stream().sorted(Comparator.comparing(Payment::getCustomer)).forEach(System.out::println);
    }
}
