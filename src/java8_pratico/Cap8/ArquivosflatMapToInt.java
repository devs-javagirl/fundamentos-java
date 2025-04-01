package java8_pratico.Cap8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArquivosflatMapToInt {
    public static void main(String[] args) {
        Path diretorio = Paths.get("C:/arq_estudo_java/exemplo");

        try {
            IntStream caracteres = Files.list(diretorio)
                    .filter(p -> p.toString().endsWith(".java"))
                    .flatMap(ArquivosflatMapToInt::lines)
                    .flatMapToInt(s -> s.chars()); // Converte String ? IntStream (evita boxing)

            caracteres.forEach(c -> System.out.print((char) c)); // Exibe caracteres dos arquivos .java
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
