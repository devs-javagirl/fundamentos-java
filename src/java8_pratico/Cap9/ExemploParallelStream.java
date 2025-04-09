package java8_pratico.Cap9;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.ThreadLocalRandom;

public class ExemploParallelStream {

    public static void main(String[] args) {
        List<Usuario> usuarios = gerarUsuarios(10_000_000); // Gere 10 milhões de usuários

        // Exemplo 1: Stream sequencial
        long inicio1 = System.currentTimeMillis();
        List<Usuario> sequencial = usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());
        long fim1 = System.currentTimeMillis();
        System.out.println("Tempo sequencial: " + (fim1 - inicio1) + " ms");

        // Exemplo 2: Stream paralelo
        long inicio2 = System.currentTimeMillis();
        List<Usuario> paralelo = usuarios.parallelStream()
                .filter(u -> u.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome))
                .collect(Collectors.toList());
        long fim2 = System.currentTimeMillis();
        System.out.println("Tempo paralelo: " + (fim2 - inicio2) + " ms");

        // Exemplo 3: LongStream sequencial
        long inicio3 = System.currentTimeMillis();
        long somaSeq = LongStream.range(0, 1_000_000_000)
                .filter(x -> x % 2 == 0)
                .sum();
        long fim3 = System.currentTimeMillis();
        System.out.println("Soma sequencial: " + somaSeq + " | Tempo: " + (fim3 - inicio3) + " ms");

        // Exemplo 4: LongStream paralelo
        long inicio4 = System.currentTimeMillis();
        long somaPar = LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();
        long fim4 = System.currentTimeMillis();
        System.out.println("Soma paralela: " + somaPar + " | Tempo: " + (fim4 - inicio4) + " ms");
    }

    // Método para gerar usuários aleatórios
    private static List<Usuario> gerarUsuarios(int quantidade) {
        List<Usuario> lista = new ArrayList<>(quantidade);
        for (int i = 0; i < quantidade; i++) {
            int pontos = ThreadLocalRandom.current().nextInt(0, 200);
            String nome = "Usuario" + i;
            lista.add(new Usuario(nome, pontos));
        }
        return lista;
    }

    // Classe Usuario simples
    static class Usuario {
        private String nome;
        private int pontos;

        public Usuario(String nome, int pontos) {
            this.nome = nome;
            this.pontos = pontos;
        }

        public String getNome() {
            return nome;
        }

        public int getPontos() {
            return pontos;
        }

        @Override
        public String toString() {
            return nome + " (" + pontos + ")";
        }
    }
}
