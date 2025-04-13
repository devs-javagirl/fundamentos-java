package java8_pratico.Cap10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

public class ExemploDatasInvalidas {

    /*
    ? O que esse código demonstra:
    exemploComCalendar(): o Calendar ajusta automaticamente a data inválida para uma válida (sem avisar).
    exemploComNovaApi(): a nova API (LocalDate, LocalDateTime) lança exceção quando a data ou hora é inválida.
    */
    public static void main(String[] args) {

        System.out.println("== Exemplo com Calendar (antigo) ==");
        exemploComCalendar();

        System.out.println("\n== Exemplo com java.time (novo) ==");
        exemploComNovaApi();
    }

    private static void exemploComCalendar() {
        Calendar instante = Calendar.getInstance();

        // Tenta criar 30 de fevereiro de 2014 (data inválida)
        instante.set(2014, Calendar.FEBRUARY, 30);

        // Formata e exibe
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        System.out.println("Data formatada (ajustada automaticamente): " + dateFormat.format(instante.getTime()));
        // Saída: 02/03/14
    }

    private static void exemploComNovaApi() {
        try {
            // Tenta criar 30 de fevereiro de 2014 (data inválida)
            LocalDate dataInvalida = LocalDate.of(2014, Month.FEBRUARY, 30);
            System.out.println("Data válida: " + dataInvalida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (DateTimeException e) {
            System.out.println("Erro ao criar data inválida: " + e.getMessage());
        }

        try {
            // Tenta criar horário inválido: 25h
            LocalDateTime horaInvalida = LocalDate.now().atTime(25, 0);
            System.out.println("Horário válido: " + horaInvalida);
        } catch (DateTimeException e) {
            System.out.println("Erro ao criar horário inválido: " + e.getMessage());
        }
    }
}

