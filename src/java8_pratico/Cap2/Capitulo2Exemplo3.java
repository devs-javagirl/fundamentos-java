package java8_pratico.Cap2;

import java.util.Arrays;
import java.util.List;

public class Capitulo2Exemplo3 {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);
    }
}
