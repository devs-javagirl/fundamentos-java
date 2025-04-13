package java8_pratico.Cap10;

import java.util.Calendar;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.LocalDateTime;

public class ExemploDuracaoPeriodo {

    public static void main(String[] args) {

        System.out.println("== Exemplo com Calendar (antigo) ==");
        exemploComCalendar();

        System.out.println("\n== Exemplo com ChronoUnit (novo) ==");
        exemploComChronoUnit();

        System.out.println("\n== Exemplo com Period ==");
        exemploComPeriod();

        System.out.println("\n== Exemplo com Period negativo ==");
        exemploComPeriodNegativo();

        System.out.println("\n== Exemplo com Duration (para horas/minutos/segundos) ==");
        exemploComDuration();
    }

    private static void exemploComCalendar() {
        Calendar agora = Calendar.getInstance();
        Calendar outraData = Calendar.getInstance();
        outraData.set(1988, Calendar.JANUARY, 25);

        long diferenca = agora.getTimeInMillis() - outraData.getTimeInMillis();
        long milissegundosDeUmDia = 1000 * 60 * 60 * 24;
        long dias = diferenca / milissegundosDeUmDia;

        System.out.println("Diferença em dias (aproximada): " + dias);
    }

    private static void exemploComChronoUnit() {
        LocalDate agora = LocalDate.now();
        LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);

        long dias = ChronoUnit.DAYS.between(outraData, agora);
        long meses = ChronoUnit.MONTHS.between(outraData, agora);
        long anos = ChronoUnit.YEARS.between(outraData, agora);

        System.out.printf("%d dias, %d meses, %d anos%n", dias, meses, anos);
    }

    private static void exemploComPeriod() {
        LocalDate agora = LocalDate.now();
        LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);

        Period periodo = Period.between(outraData, agora);

        System.out.printf("%d dias, %d meses, %d anos%n",
                periodo.getDays(), periodo.getMonths(), periodo.getYears());
    }

    private static void exemploComPeriodNegativo() {
        LocalDate agora = LocalDate.now();
        LocalDate outraData = LocalDate.of(2030, Month.JANUARY, 25);

        Period periodo = Period.between(outraData, agora);

        if (periodo.isNegative()) {
            periodo = periodo.negated(); // transforma os valores em positivos
        }

        System.out.printf("%d dias, %d meses, %d anos%n",
                periodo.getDays(), periodo.getMonths(), periodo.getYears());
    }

    private static void exemploComDuration() {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fim = inicio.plusHours(5).plusMinutes(30).plusSeconds(15);

        Duration duracao = Duration.between(inicio, fim);

        System.out.printf("Duração: %d horas, %d minutos, %d segundos%n",
                duracao.toHours(), duracao.toMinutesPart(), duracao.toSecondsPart());
    }
}

