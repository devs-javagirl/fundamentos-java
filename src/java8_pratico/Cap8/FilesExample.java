package java8_pratico.Cap8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesExample {
    public static void main(String[] args) throws IOException {
        // Listar arquivos .java
        Files.list(Paths.get("./arquivos"))
                .filter(p -> p.toString().endsWith(".txt"))
                .forEach(System.out::println);

        // Tentativa de ler linhas (gera Stream<Stream<String>>)
        Files.list(Paths.get("./arquivos"))
                .filter(p -> p.toString().endsWith(".txt"))
                .map(p -> lines(p))
                .forEach(System.out::println);
    }

    // Método auxiliar para tratar IOException
    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
