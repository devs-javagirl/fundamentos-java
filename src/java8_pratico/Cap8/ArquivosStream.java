package java8_pratico.Cap8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ArquivosStream {
    public static void main(String[] args) {
        Path diretorio = Paths.get("C:/arq_estudo_java");

        try {
            Files.list(diretorio)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }

        System.out.println("-----Lista as linhas de um arquivo");
        diretorio = Paths.get("C:\\arq_estudo_java\\exemplo\\Exemplo.java");
        Stream<String> linhas = lines(diretorio);
        linhas.forEach(System.out::println);
    }

    static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e); // Converte para exceção não verificada
        }
    }
}
