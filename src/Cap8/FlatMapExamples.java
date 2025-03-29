package Cap8;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapExamples {

    // Classes auxiliares para os exemplos
    static class Usuario {
        private String nome;
        private List<Pedido> pedidos;

        public Usuario(String nome, List<Pedido> pedidos) {
            this.nome = nome;
            this.pedidos = pedidos;
        }

        public Stream<Pedido> getPedidos() {
            return pedidos.stream();
        }

        @Override
        public String toString() {
            return nome;
        }
    }

    static class Grupo {
        private Set<Usuario> usuarios = new HashSet<>();

        public void add(Usuario u) {
            usuarios.add(u);
        }

        public Stream<Usuario> getUsuarios() {
            return usuarios.stream();
        }
    }

    static class Pedido {
        private String id;

        public Pedido(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Pedido-" + id;
        }
    }

    public static void main(String[] args) {
        exemploArquivosFlatMap();
        exemploCaracteresFlatMap();
        exemploGruposUsuarios();
        exemploPedidosUsuarios();
    }

    // Exemplo 1: Ler linhas de arquivos .java usando flatMap
    private static void exemploArquivosFlatMap() {
        System.out.println("=== Exemplo 1: Linhas de Arquivos .java ===");

        try {
            // Substitua pelo caminho do seu diret�rio
            Path diretorio = Paths.get("./src");

            // Listar arquivos .java e ler todas as linhas
            Stream<String> linhas = Files.list(diretorio)
                    .filter(p -> p.toString().endsWith(".java"))
                    .flatMap(p -> lines(p)); // Usando flatMap para Stream<String>

            linhas.limit(5).forEach(System.out::println); // Limita a 5 linhas para demonstra��o

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivos: " + e.getMessage());
        }
    }

    // Exemplo 2: Extrair caracteres de todas as linhas usando flatMapToInt
    private static void exemploCaracteresFlatMap() {
        System.out.println("\n=== Exemplo 2: Caracteres de Linhas ===");

        try {
            Path diretorio = Paths.get("./src");

            IntStream caracteres = Files.list(diretorio)
                    .filter(p -> p.toString().endsWith(".java"))
                    .flatMap(p -> lines(p))
                    .flatMapToInt(s -> s.chars()); // Converte para IntStream

            caracteres.limit(20).forEach(c -> System.out.print((char) c + " ")); // Limita a 20 caracteres

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Exemplo 3: Obter usu�rios distintos de grupos
    private static void exemploGruposUsuarios() {
        System.out.println("\n\n=== Exemplo 3: Usu�rios de Grupos ===");

        // Criar usu�rios
        Usuario alice = new Usuario("Alice", List.of(new Pedido("A1")));
        Usuario bob = new Usuario("Bob", List.of(new Pedido("B1")));
        Usuario carol = new Usuario("Carol", List.of(new Pedido("C1")));

        // Criar grupos
        Grupo grupo1 = new Grupo();
        grupo1.add(alice);
        grupo1.add(bob);

        Grupo grupo2 = new Grupo();
        grupo2.add(bob);
        grupo2.add(carol);

        List<Grupo> grupos = Arrays.asList(grupo1, grupo2);

        // Obter todos os usu�rios distintos
        grupos.stream()
                .flatMap(g -> g.getUsuarios()) // Achata para Stream<Usuario>
                .distinct()
                .forEach(u -> System.out.println("Usu�rio: " + u));
    }

    // Exemplo 4: Coletar todos os pedidos de usu�rios
    private static void exemploPedidosUsuarios() {
        System.out.println("\n=== Exemplo 4: Pedidos de Usu�rios ===");

        // Criar usu�rios com pedidos
        Usuario dave = new Usuario("Dave", List.of(new Pedido("D1"), new Pedido("D2")));
        Usuario eve = new Usuario("Eve", List.of(new Pedido("E1")));

        List<Usuario> usuarios = Arrays.asList(dave, eve);

        // Obter todos os pedidos
        usuarios.stream()
                .flatMap(u -> u.getPedidos()) // Achata para Stream<Pedido>
                .forEach(p -> System.out.println(p));
    }

    // M�todo auxiliar para tratar IOException
    private static Stream<String> lines(Path p) {
        try {
            return Files.lines(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
