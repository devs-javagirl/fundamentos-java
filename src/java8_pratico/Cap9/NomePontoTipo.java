package java8_pratico.Cap9;

import java.util.*;
import java.util.stream.Collectors;

public class NomePontoTipo {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);
        Usuario user4 = new Usuario("Sergio Lopes", 120);
        Usuario user5 = new Usuario("Adriano Almeida", 100);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        // Gerando uma lista de nomes dos usuários por tipo
        Map<Boolean, List<String>> nomesPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(
                        Usuario::isModerador,
                        Collectors.mapping(Usuario::getNome, Collectors.toList())
                ));

        // Usando summingInt para calcular a soma de pontos
        Map<Boolean, Integer> pontuacaoPorTipo = usuarios.stream()
                .collect(Collectors.partitioningBy(
                        Usuario::isModerador,
                        Collectors.summingInt(Usuario::getPontos)
                ));

        // Gerando uma string com todos os nomes separados por vírgula
        String nomes = usuarios.stream()
                .map(Usuario::getNome)
                .collect(Collectors.joining(", "));

        // Exibir nomes por tipo
        System.out.println("Nomes dos usuários por tipo:");
        nomesPorTipo.forEach((isModerador, lista) ->
                System.out.println((isModerador ? "Moderadores" : "Não Moderadores") + " -> " + lista));

        // Exibir soma de pontos por tipo
        System.out.println("\nSoma de pontos por tipo:");
        pontuacaoPorTipo.forEach((isModerador, soma) ->
                System.out.println((isModerador ? "Moderadores" : "Não Moderadores") + " -> " + soma));

        // Exibir todos os nomes concatenados
        System.out.println("\nLista completa de nomes: " + nomes);
    }
}
