package java8_pratico.Cap9;

import java.util.*;

public class ListaTradicional {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90);
        Usuario user4 = new Usuario("Sergio Lopes", 120);
        Usuario user5 = new Usuario("Adriano Almeida", 100);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        Map<Integer, List<Usuario>> pontuacao = new HashMap<>();
        for (Usuario u : usuarios) {
            pontuacao.putIfAbsent(u.getPontos(), new ArrayList<>());
            pontuacao.get(u.getPontos()).add(u);
        }

        // Exibir o mapa de pontuações
        for (Map.Entry<Integer, List<Usuario>> entry : pontuacao.entrySet()) {
            System.out.println("Pontos: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
