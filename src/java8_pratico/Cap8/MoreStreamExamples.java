package java8_pratico.Cap8;

import java8_pratico.Cap6.Usuario2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MoreStreamExamples {

    public static void testIterator(List<Usuario2> usuarios) {
        System.out.println("Usando Iterator:");
        Iterator<Usuario2> i = usuarios.stream().iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public static void testForEachRemaining(List<Usuario2> usuarios) {
        System.out.println("Usando forEachRemaining:");
        usuarios.stream().iterator().forEachRemaining(System.out::println);
    }

    public static void testPredicates(List<Usuario2> usuarios) {
        System.out.println("Testando Predicates:");
        System.out.println("Algum moderador? " + usuarios.stream().anyMatch(Usuario2::isModerador));
        System.out.println("Todos moderadores? " + usuarios.stream().allMatch(Usuario2::isModerador));
        System.out.println("Nenhum moderador? " + usuarios.stream().noneMatch(Usuario2::isModerador));
    }

    public static void testStreamMethods(List<Usuario2> usuarios) {
        System.out.println("Métodos do Stream:");
        System.out.println("Total de usuários: " + usuarios.stream().count());

        System.out.println("Pulando os 2 primeiros:");
        usuarios.stream().skip(2).forEach(System.out::println);

        System.out.println("Limitando aos 3 primeiros:");
        usuarios.stream().limit(3).forEach(System.out::println);
    }

    public static void testCreatingStreams() {
        System.out.println("Criando Streams:");
        Stream<Usuario2> vazio = Stream.empty();
        System.out.println("Stream vazio: " + vazio.count());

        Usuario2 u1 = new Usuario2("Alice", false);
        Usuario2 u2 = new Usuario2("Bob", true);
        Usuario2 u3 = new Usuario2("Carol", false);

        Stream<Usuario2> stream = Stream.of(u1, u2, u3);
        System.out.println("Stream a partir de elementos:");
        stream.forEach(System.out::println);
    }

    public static void testConcatStreams() {
        System.out.println("Concatenando Streams:");
        Stream<String> stream1 = Stream.of("Java", "Python");
        Stream<String> stream2 = Stream.of("C++", "JavaScript");

        Stream<String> concatenado = Stream.concat(stream1, stream2);
        concatenado.forEach(System.out::println);
    }

    public static void testPatternSplit() {
        System.out.println("Dividindo String com Regex:");
        Pattern pattern = Pattern.compile(",");
        Stream<String> stream = pattern.splitAsStream("Java,Python,C++");
        stream.forEach(System.out::println);
    }

    public static void testReadFile() {
        System.out.println("Lendo Arquivo com Stream:");
        try (Stream<String> linhas = Files.lines(Paths.get("arquivo.txt"))) {
            linhas.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public static void testArrayStream() {
        System.out.println("Criando Stream a partir de Array:");
        String[] linguagens = {"Java", "Python", "C++"};
        Stream<String> stream = Arrays.stream(linguagens);
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Usuario2> usuarios = Arrays.asList(
                new Usuario2("Carlos", true),
                new Usuario2("Mariana", false),
                new Usuario2("João", true),
                new Usuario2("Ana", false)
        );

        testIterator(usuarios);
        testForEachRemaining(usuarios);
        testPredicates(usuarios);
        testStreamMethods(usuarios);
        testCreatingStreams();
        testConcatStreams();
        testPatternSplit();
        testArrayStream();

        // Caso tenha um arquivo "arquivo.txt", descomente para testar:
        // testReadFile();
    }
}
