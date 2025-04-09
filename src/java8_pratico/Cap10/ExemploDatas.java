package java8_pratico.Cap10;

import java.time.LocalDate;

public class ExemploDatas {
    public static void main(String[] args) {
        // Data atual
        LocalDate hoje = LocalDate.now();
        System.out.println("Hoje: " + hoje);

        // Adicionando dias, meses e anos
        LocalDate daquiA5Dias = hoje.plusDays(5);
        System.out.println("Daqui a 5 dias: " + daquiA5Dias);

        LocalDate mesQueVem = hoje.plusMonths(1);
        System.out.println("Mês que vem: " + mesQueVem);

        LocalDate daquiA2Anos = hoje.plusYears(2);
        System.out.println("Daqui a 2 anos: " + daquiA2Anos);

        // Subtraindo dias, meses e anos
        LocalDate ha7Dias = hoje.minusDays(7);
        System.out.println("7 dias atrás: " + ha7Dias);

        LocalDate mesPassado = hoje.minusMonths(1);
        System.out.println("Mês passado: " + mesPassado);

        LocalDate ha3Anos = hoje.minusYears(3);
        System.out.println("3 anos atrás: " + ha3Anos);
    }
}
