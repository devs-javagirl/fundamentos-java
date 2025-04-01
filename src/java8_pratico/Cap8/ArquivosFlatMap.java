package java8_pratico.Cap8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ArquivosFlatMap {
    public static void main(String[] args) {
        Path diretorio = Paths.get("C:/arq_estudo_java");

        try {
            Stream<String> linhas = Files.list(diretorio)
                    .filter(p -> p.toString().endsWith(".java"))
                    .flatMap(ArquivosFlatMap::lines); // Converte Stream<Stream<String>> ? Stream<String>

            linhas.forEach(System.out::println); // Exibe o conteúdo dos arquivos .java
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }
    }

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e); // Converte para exceção não verificada
        }
    }
}
