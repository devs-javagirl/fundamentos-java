package java8_pratico.Cap9;

import java.util.*;
import java.util.stream.Collectors;

public class ListaGroupPart {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);
        Usuario user4 = new Usuario("Sergio Lopes", 120);
        Usuario user5 = new Usuario("Adriano Almeida", 90);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        // Agrupar usuários por pontuação
        Map<Integer, List<Usuario>> pontuacao = usuarios.stream()
                .collect(Collectors.groupingBy(Usuario::getPontos));

        // Particionar usuários entre moderadores e não moderadores
        Map<Boolean, List<Usuario>> moderadores = usuarios.stream()
                .collect(Collectors.partitioningBy(Usuario::isModerador));

        // Exibir o mapa de pontuações
        System.out.println("Usuários agrupados por pontuação:");
        pontuacao.forEach((pontos, lista) ->
                System.out.println("Pontos: " + pontos + " -> " + lista));

        // Exibir o mapa de moderadores
        System.out.println("\nUsuários particionados entre moderadores e não moderadores:");
        moderadores.forEach((isModerador, lista) ->
                System.out.println((isModerador ? "Moderadores" : "Não Moderadores") + " -> " + lista));
    }
}
