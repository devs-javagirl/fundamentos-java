package java8_pratico.Cap9;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NameToUserJPA {
    public static void main(String[] args) {
        // Criando alguns usu�rios
        Usuario user1 = new Usuario(1L, "Paulo Silveira", 150, true);
        Usuario user2 = new Usuario(2L, "Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario(3L, "Guilherme Silveira", 90, false);
        Usuario user4 = new Usuario(4L, "Sergio Lopes", 120, false);
        Usuario user5 = new Usuario(5L, "Adriano Almeida", 100, false);

        // Lista de usu�rios
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        // Gerando um mapa com ID do usu�rio como chave e o pr�prio objeto Usuario como valor
        Map<Long, Usuario> nameToUser = usuarios.stream()
                .collect(Collectors.toMap(
                        Usuario::getId,        // A chave � o ID do usu�rio
                        Function.identity()     // O valor � o pr�prio objeto Usuario
                ));

        // Exibe o mapa com os IDs dos usu�rios e os objetos associados
        nameToUser.forEach((id, usuario) ->
                System.out.println(id + " -> " + usuario));
    }
}

