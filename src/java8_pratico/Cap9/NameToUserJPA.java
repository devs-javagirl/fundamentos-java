package java8_pratico.Cap9;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NameToUserJPA {
    public static void main(String[] args) {
        // Criando alguns usuários
        Usuario user1 = new Usuario(1L, "Paulo Silveira", 150, true);
        Usuario user2 = new Usuario(2L, "Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario(3L, "Guilherme Silveira", 90, false);
        Usuario user4 = new Usuario(4L, "Sergio Lopes", 120, false);
        Usuario user5 = new Usuario(5L, "Adriano Almeida", 100, false);

        // Lista de usuários
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        // Gerando um mapa com ID do usuário como chave e o próprio objeto Usuario como valor
        Map<Long, Usuario> nameToUser = usuarios.stream()
                .collect(Collectors.toMap(
                        Usuario::getId,        // A chave é o ID do usuário
                        Function.identity()     // O valor é o próprio objeto Usuario
                ));

        // Exibe o mapa com os IDs dos usuários e os objetos associados
        nameToUser.forEach((id, usuario) ->
                System.out.println(id + " -> " + usuario));
    }
}

