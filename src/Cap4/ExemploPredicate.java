package Cap4;

import Cap4.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExemploPredicate {
    public static void main(String[] args) {
        // Criando usuários
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        // Criando uma lista mutável de usuários
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        // Criando um Predicate para remover usuários com mais de 160 pontos
//        Predicate<Usuario> predicado = new Predicate<Usuario>() {
//            @Override
//            public boolean test(Usuario u) {
//                return u.getPontos() > 160;
//            }
//        };

        //usando lambda
        usuarios.removeIf(u -> u.getPontos() > 160);

        // Removendo usuários que satisfazem a condição do Predicate
        //usuarios.removeIf(predicado);

        // Exibindo a lista após a remoção
        usuarios.forEach(System.out::println);
    }
}