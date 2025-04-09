package java8_pratico.Cap10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExemploFormatacaoDataHora {

    public static void main(String[] args) {
        // Data e hora atual
        LocalDateTime agora = LocalDateTime.now();

        // Formatação usando os padrões prontos da API
        String horaFormatada = agora.format(DateTimeFormatter.ISO_LOCAL_TIME);
        String dataFormatada = agora.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String dataHoraFormatada = agora.format(DateTimeFormatter.ISO_DATE_TIME);

        System.out.println("Hora formatada (ISO_LOCAL_TIME): " + horaFormatada);
        System.out.println("Data formatada (ISO_LOCAL_DATE): " + dataFormatada);
        System.out.println("Data e hora formatada (ISO_DATE_TIME): " + dataHoraFormatada);

        // Formatação personalizada
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataPersonalizada = agora.format(formatador);
        System.out.println("Data formatada personalizada: " + dataPersonalizada);

        // Formatação personalizada com Locale
        DateTimeFormatter formatadorComLocale = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt"));
        String dataComLocale = agora.format(formatadorComLocale);
        System.out.println("Data formatada com Locale pt: " + dataComLocale);

        // Convertendo String para LocalDate (parse)
        LocalDate dataConvertida = LocalDate.parse(dataPersonalizada, formatador);
        System.out.println("Data convertida de String para LocalDate: " + dataConvertida);
    }
}
