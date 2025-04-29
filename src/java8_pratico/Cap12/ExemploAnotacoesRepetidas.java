package java8_pratico.Cap12;

import java.lang.annotation.*;
import java.util.Arrays;

// Classe anotada com v�rias @Role
@Role("presidente")
@Role("diretor")
class RelatorioController { }

// Classe principal para testar a leitura das anota��es
public class ExemploAnotacoesRepetidas {
    public static void main(String[] args) {
        RelatorioController controller = new RelatorioController();
        Role[] roles = controller.getClass().getAnnotationsByType(Role.class);

        Arrays.asList(roles)
                .forEach(role -> System.out.println(role.value()));
    }
}

