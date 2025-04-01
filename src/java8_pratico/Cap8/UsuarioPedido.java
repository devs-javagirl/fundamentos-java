package java8_pratico.Cap8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UsuarioPedido {
    public static void main(String[] args) {
        // Criando pedidos
        Pedido pedido1 = new Pedido("Pedido 1");
        Pedido pedido2 = new Pedido("Pedido 2");
        Pedido pedido3 = new Pedido("Pedido 3");
        Pedido pedido4 = new Pedido("Pedido 4");

        // Criando usuários e associando pedidos
        Usuario usuario1 = new Usuario(Arrays.asList(pedido1, pedido2));
        Usuario usuario2 = new Usuario(Arrays.asList(pedido3, pedido4));

        // Lista de usuários
        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);

        // Usando flatMap para extrair todos os pedidos de todos os usuários
        Stream<Pedido> todosPedidos = usuarios.stream()
                .flatMap(u -> u.getPedidos()); // Achata Stream<Stream<Pedido>> ? Stream<Pedido>

        // Exibindo todos os pedidos
        todosPedidos.forEach(System.out::println);  // Exibe todos os pedidos
    }
}
