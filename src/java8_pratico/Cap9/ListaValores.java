package java8_pratico.Cap9;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class ListaValores {
    public static void main(String[] args) {
        // Caminho do diretório
        Path dirPath = Paths.get("C:/arq_estudo_java/");

        try {
            // Gerar uma lista com a quantidade de linhas de cada arquivo .java
            List<Long> lines = Files.list(dirPath)
                    .filter(p -> p.toString().endsWith(".java")) // Filtra arquivos .java
                    .map(p -> {
                        try {
                            return Files.lines(p).count(); // Conta as linhas do arquivo
                        } catch (IOException e) {
                            e.printStackTrace();
                            return 0L; // Retorna 0 se houver erro na leitura do arquivo
                        }
                    })
                    .collect(Collectors.toList()); // Coleta os valores em uma lista

            // Exibir a quantidade de linhas dos arquivos
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

