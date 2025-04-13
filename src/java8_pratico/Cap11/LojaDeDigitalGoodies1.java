package java8_pratico.Cap11;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;

// Classe principal da loja de digital goodies
public class LojaDeDigitalGoodies1 {

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

        // Criando datas
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        LocalDateTime lastMonth = today.minusMonths(1);

        // Criando pagamentos
        Payment payment1 = new Payment(Arrays.asList(bach, poderosas), today, paulo);
        Payment payment2 = new Payment(Arrays.asList(bach, bandeira, amelie), yesterday, rodrigo);
        Payment payment3 = new Payment(Arrays.asList(beauty, vingadores, bach), today, adriano);

        // Imprimindo pagamentos
        System.out.println(payment1);
        System.out.println(payment2);
        System.out.println(payment3);
    }
}
