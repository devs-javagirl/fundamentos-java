package Cap2;

import java.util.Arrays;
import java.util.List;

public class Capitulo2Exemplo6 {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //opcao 0
       // Consumer<Usuario> mostrador =
       //         (Usuario u) -> {System.out.println(u.getNome());};

        //opcao 1
       // Consumer<Usuario> mostrador = u -> { System.out.println(u.getNome()); };

        //opcao 2
      //  Consumer<Usuario> mostrador = u -> System.out.println(u.getNome());

      //  usuarios.forEach(mostrador);

        //opcao 3
        usuarios.forEach(u -> System.out.println(u.getNome()));

        usuarios.forEach(x -> x.tornaModerador());


    }

}
