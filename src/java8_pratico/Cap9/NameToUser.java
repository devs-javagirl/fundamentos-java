package java8_pratico.Cap9;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NameToUser {
    public static void main(String[] args) {
        // Criando alguns usu�rios
        Usuario user1 = new Usuario("Paulo Silveira", 150, true);
        Usuario user2 = new Usuario("Rodrigo Turini", 120, true);
        Usuario user3 = new Usuario("Guilherme Silveira", 90, false);
        Usuario user4 = new Usuario("Sergio Lopes", 120, false);
        Usuario user5 = new Usuario("Adriano Almeida", 100, false);

        // Lista de usu�rios
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);

        // Gerando um mapa com nome do usu�rio como chave e o pr�prio objeto Usuario como valor
        Map<String, Usuario> nameToUser = usuarios.stream()
                .collect(Collectors.toMap(
                        Usuario::getNome,     // A chave � o nome do usu�rio
                        Function.identity()    // O valor � o pr�prio objeto Usuario
                ));

        // Exibe o mapa com os nomes dos usu�rios e os objetos associados
        nameToUser.forEach((nome, usuario) ->
                System.out.println(nome + " -> " + usuario));
    }
}

