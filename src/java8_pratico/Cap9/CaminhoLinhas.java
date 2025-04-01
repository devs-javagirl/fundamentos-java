package java8_pratico.Cap9;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class CaminhoLinhas {
    public static void main(String[] args) {
        // Caminho do diretório
        Path dirPath = Paths.get("C:/arq_estudo_java/");

        // Mapa para armazenar o caminho do arquivo e o número de linhas
        Map<Path, Long> linesPerFile = new HashMap<>();

        try {
            // Para cada arquivo .java, armazena o caminho e o número de linhas no mapa
            Files.list(dirPath)
                    .filter(p -> p.toString().endsWith(".java")) // Filtra arquivos .java
                    .forEach(p -> {
                        try {
                            linesPerFile.put(p, Files.lines(p).count()); // Conta as linhas e coloca no mapa
                        } catch (IOException e) {
                            e.printStackTrace(); // Tratamento de erro
                        }
                    });

            // Exibe o mapa de arquivos e suas respectivas quantidades de linhas
            linesPerFile.forEach((path, lineCount) ->
                    System.out.println(path + " = " + lineCount + " linhas"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

