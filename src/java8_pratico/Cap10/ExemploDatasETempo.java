package java8_pratico.Cap10;

import java.time.*;

public class ExemploDatasETempo {
    public static void main(String[] args) {
        // Apenas a data de hoje
        LocalDate hoje = LocalDate.now();
        System.out.println("Data de hoje: " + hoje);

        // Data e hora atual
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("Data e hora agora: " + agora);

        // Data de hoje �s 12:00
        LocalDateTime hojeAoMeioDia = hoje.atTime(12, 0);
        System.out.println("Hoje ao meio-dia: " + hojeAoMeioDia);

        // Apenas o hor�rio atual
        LocalTime horarioAgora = LocalTime.now();
        System.out.println("Hor�rio agora: " + horarioAgora);

        // Data de hoje + hora atual
        LocalDateTime dataEhora = hoje.atTime(horarioAgora);
        System.out.println("Data e hora juntos: " + dataEhora);

        // Data, hora e timezone
        ZonedDateTime dataComHoraETimezone = dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Data, hora e timezone: " + dataComHoraETimezone);

        // Convertendo ZonedDateTime para LocalDateTime (removendo o timezone)
        LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();
        System.out.println("Data e hora sem timezone: " + semTimeZone);

        // Convertendo LocalDateTime para LocalDate (pegando s� a data)
        LocalDate apenasData = dataEhora.toLocalDate();
        System.out.println("Apenas a data: " + apenasData);
    }
}
