package java8_pratico.Cap9;

import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.stream.Collectors;

public class CaminhoLinhasFuncional {
    public static void main(String[] args) {
        // Caminho do diretório
        Path dirPath = Paths.get("C:/arq_estudo_java/");

        try {
            // Usando Collectors.toMap para gerar o mapa de arquivos e suas respectivas quantidades de linhas
            Map<Path, Long> lines = Files.list(dirPath)
                    .filter(p -> p.toString().endsWith(".java")) // Filtra arquivos .java
                    .collect(Collectors.toMap(
                            p -> p, // A chave é o próprio Path
                            p -> {
                                try {
                                    return Files.lines(p).count(); // Conta as linhas do arquivo
                                } catch (IOException e) {
                                    e.printStackTrace(); // Tratamento de erro
                                    return 0L; // Caso ocorra erro, retorna 0 como número de linhas
                                }
                            }
                    ));

            // Exibe o mapa de arquivos e suas respectivas quantidades de linhas
            lines.forEach((path, lineCount) ->
                    System.out.println(path + " = " + lineCount + " linhas"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
