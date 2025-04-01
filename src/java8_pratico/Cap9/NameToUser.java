package java8_pratico.Cap9;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NameToUser {
    public static void main(String[] args) {
        // Criando alguns usuários
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90, false);
        Usuario user4 = new Usuario("Sergio Lopes", 120, false);
        Usuario user5 = new Usuario("Adriano Almeida", 100, false);

        // Lista de usuários
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        // Gerando um mapa com nome do usuário como chave e o próprio objeto Usuario como valor
        Map<String, Usuario> nameToUser = usuarios.stream()
                .collect(Collectors.toMap(
                        Usuario::getNome,     // A chave é o nome do usuário
                        Function.identity()    // O valor é o próprio objeto Usuario
                ));

        // Exibe o mapa com os nomes dos usuários e os objetos associados
        nameToUser.forEach((nome, usuario) ->
                System.out.println(nome + " -> " + usuario));
    }
}

