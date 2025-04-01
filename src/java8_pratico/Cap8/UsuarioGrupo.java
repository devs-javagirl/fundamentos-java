package java8_pratico.Cap8;

import java.util.Arrays;
import java.util.List;

public class UsuarioGrupo {
    public static void main(String[] args) {
        // Criando usuários
        Usuario john = new Usuario("John");
        Usuario maria = new Usuario("Maria");
        Usuario pedro = new Usuario("Pedro");
        Usuario ana = new Usuario("Ana");

        // Criando grupos
        Grupo englishSpeakers = new Grupo();
        englishSpeakers.add(john);
        englishSpeakers.add(maria);

        Grupo spanishSpeakers = new Grupo();
        spanishSpeakers.add(pedro);
        spanishSpeakers.add(ana);
        spanishSpeakers.add(john); // John aparece em ambos os grupos

        // Lista de grupos
        List<Grupo> grupos = Arrays.asList(englishSpeakers, spanishSpeakers);

        // Processando os grupos
        grupos.stream()
                .flatMap(g -> g.getUsuarios()) // Achata para Stream<Usuario>
                .distinct() // Remove usuários duplicados
                .forEach(System.out::println); // Exibe os usuários únicos
    }
}
