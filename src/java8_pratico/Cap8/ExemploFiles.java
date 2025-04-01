package java8_pratico.Cap8;

import java.nio.file.*;
import java.io.*;
import java.util.stream.*;

public class ExemploFiles {
    public static void main(String[] args) throws IOException {
        // Listar arquivos .java
        Files.list(Paths.get("C:/arq_estudo_java"))
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(System.out::println);

        // Tentativa de ler linhas (gera Stream<Stream<String>>)
        Files.list(Paths.get("C:/arq_estudo_java"))
                .filter(p -> p.toString().endsWith(".java"))
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
