package java8_pratico.Cap10;

import java.time.LocalDate;
import java.time.Period;

public class ComparacaoJodaNovaAPI {

    public static void main(String[] args) {
        // Exemplo com a nova API (java.time)

        LocalDate dataInicial = LocalDate.of(2020, 1, 1);
        LocalDate dataFinal = LocalDate.of(2024, 4, 10);

        Period periodo = Period.between(dataInicial, dataFinal);

        System.out.println("Nova API - Period:");
        System.out.printf("Anos: %d, Meses: %d, Dias: %d%n",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());

        // Tentando passar null (vai lançar NullPointerException)
        try {
            Period erro = Period.between(null, dataFinal);
        } catch (NullPointerException e) {
            System.out.println("Erro esperado ao passar null: " + e.getMessage());
        }

        /*
         * OBS:
         * No Joda-Time (não disponível diretamente aqui), seria possível fazer algo como:
         * DateTime data = null;
         * Period periodo = new Period(data, outroData); // e null seria tratado como 1970-01-01
         *
         * Isso era perigoso e levava a resultados inesperados.
         */
    }
}

