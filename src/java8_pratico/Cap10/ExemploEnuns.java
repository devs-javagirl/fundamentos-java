package java8_pratico.Cap10;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class ExemploEnuns {
    public static void main(String[] args) {
        // Criando uma data usando enum Month (mais legível)
        LocalDate natal2014 = LocalDate.of(2014, Month.DECEMBER, 25);
        System.out.println("Natal de 2014: " + natal2014);

        // Descobrindo o primeiro mês do trimestre de DEZEMBRO
        Month mes = Month.DECEMBER;
        Month primeiroMesDoTrimestre = mes.firstMonthOfQuarter();
        System.out.println("Primeiro mês do trimestre de " + mes + ": " + primeiroMesDoTrimestre);

        // Avançando 3 meses a partir de DEZEMBRO
        Month depoisDeTresMeses = mes.plus(3);
        System.out.println("3 meses depois de " + mes + ": " + depoisDeTresMeses);

        // Retrocedendo 2 meses a partir de DEZEMBRO
        Month antesDeDoisMeses = mes.minus(2);
        System.out.println("2 meses antes de " + mes + ": " + antesDeDoisMeses);

        // Obtendo o nome do mês formatado em português (completo e abreviado)
        Locale localeBrasil = new Locale("pt");

        String nomeCompleto = mes.getDisplayName(TextStyle.FULL, localeBrasil);
        String nomeAbreviado = mes.getDisplayName(TextStyle.SHORT, localeBrasil);

        System.out.println("Nome completo do mês em português: " + nomeCompleto);
        System.out.println("Nome abreviado do mês em português: " + nomeAbreviado);
    }
}
