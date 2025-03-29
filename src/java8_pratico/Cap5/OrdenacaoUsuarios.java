package java8_pratico.Cap5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class OrdenacaoUsuarios {
    public static void main(String[] args) {
        List<Usuario1> usuarios = new ArrayList<>();
        usuarios.add(new Usuario1("Carlos", 150));
        usuarios.add(new Usuario1("Ana", 200));
        usuarios.add(new Usuario1("Bruno", 180));

        // Criando a função que extrai o nome do usuário
        Function<Usuario1, String> extraiNome = u -> u.getNome();

        // Criando o Comparator baseado na função de extração
        Comparator<Usuario1> comparator = Comparator.comparing(extraiNome);

        // Ordenando a lista de usuários pelo nome
        usuarios.sort(comparator);

        // Exibindo os usuários ordenados
        System.out.println("Usuários ordenados pelo nome:");
        usuarios.forEach(System.out::println);
    }
}
