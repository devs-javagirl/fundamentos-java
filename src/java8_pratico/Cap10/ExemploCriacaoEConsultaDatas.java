package java8_pratico.Cap10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class ExemploCriacaoEConsultaDatas {
    public static void main(String[] args) {
        // Criando uma data espec�fica
        LocalDate natal2014 = LocalDate.of(2014, 12, 25);
        System.out.println("Natal de 2014: " + natal2014);

        // Criando uma data e hora espec�fica
        LocalDateTime natal2014ComHora = LocalDateTime.of(2014, 12, 25, 10, 30);
        System.out.println("Natal de 2014 �s 10:30: " + natal2014ComHora);

        // Pegando a data atual e trocando o ano
        LocalDate dataDoPassado = LocalDate.now().withYear(1988);
        System.out.println("Data atual trocando o ano para 1988: " + dataDoPassado);

        // Obtendo o ano da data
        int ano = dataDoPassado.getYear();
        System.out.println("Ano da data: " + ano);

        // Obtendo o m�s da data
        Month mes = dataDoPassado.getMonth();
        System.out.println("M�s da data: " + mes); // Exemplo: APRIL

        // Obtendo o dia do m�s
        int dia = dataDoPassado.getDayOfMonth();
        System.out.println("Dia da data: " + dia);
    }
}
