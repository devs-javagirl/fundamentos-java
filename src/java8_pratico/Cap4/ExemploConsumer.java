package java8_pratico.Cap4;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ExemploConsumer {
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

        // Criando os Consumers
        Consumer<Usuario> mostraMensagem = u ->
                System.out.println("Antes de imprimir o nome");

        Consumer<Usuario> imprimeNome = u ->
                System.out.println(u.getNome());

        // Aplicando os Consumers na lista de usuários
        usuarios.forEach(mostraMensagem.andThen(imprimeNome));
        //usuarios.forEach(mostraMensagem);
    }
}
