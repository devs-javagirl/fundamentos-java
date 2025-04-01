package java8_pratico.Cap9;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.LongStream;

public class ListaNumLinhas {
    public static void main(String[] args) {
        // Caminho do diretório
        Path dirPath = Paths.get("C:/arq_estudo_java/");

        try {
            // Gerar um LongStream com a quantidade de linhas de cada arquivo .java
            LongStream lines = Files.list(dirPath)
                    .filter(p -> p.toString().endsWith(".java")) // Filtra arquivos .java
                    .mapToLong(p -> {
                        try {
                            return Files.lines(p).count(); // Conta as linhas do arquivo
                        } catch (IOException e) {
                            e.printStackTrace();
                            return 0L; // Retorna 0 se houver erro na leitura do arquivo
                        }
                    });

            // Exibir a quantidade de linhas de cada arquivo
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
