package java8_pratico.Cap9;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArquivoMap {
    public static void main(String[] args) {
        // Caminho do diretório
        Path dirPath = Paths.get("C:/arq_estudo_java/");

        try {
            // Usando Collectors.toMap para gerar o mapa de arquivos e suas respectivas listas de linhas
            Map<Path, List<String>> content = Files.list(dirPath)
                    .filter(p -> p.toString().endsWith(".java")) // Filtra arquivos .java
                    .collect(Collectors.toMap(
                            Function.identity(), // A chave é o próprio Path
                            p -> {
                                try {
                                    return Files.lines(p).collect(Collectors.toList()); // Coleta as linhas do arquivo em uma lista
                                } catch (IOException e) {
                                    e.printStackTrace(); // Tratamento de erro
                                    return List.of(); // Retorna uma lista vazia caso ocorra erro
                                }
                            }
                    ));

            // Exibe o conteúdo do mapa (caminho do arquivo e suas linhas)
            content.forEach((path, lines) ->
                    System.out.println(path + ":\n" + String.join("\n", lines)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
