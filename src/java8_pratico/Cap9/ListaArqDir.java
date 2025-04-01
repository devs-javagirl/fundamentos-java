package java8_pratico.Cap9;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class ListaArqDir {
    public static void main(String[] args) {
        // Caminho do diretório
        Path dirPath = Paths.get("C:/arq_estudo_java/exemplo");

        try {
            // Gerar um Stream de arquivos .java no diretório e fazer flatMap para as linhas de cada arquivo
            Stream<String> strings = Files.list(dirPath)
                    .filter(p -> p.toString().endsWith(".java")) // Filtrar arquivos .java
                    .flatMap(p -> {
                        try {
                            return Files.lines(p); // Obtém as linhas de cada arquivo
                        } catch (IOException e) {
                            e.printStackTrace();
                            return Stream.empty(); // Retorna um stream vazio em caso de erro
                        }
                    });

            // Exibir as linhas de todos os arquivos
            strings.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
