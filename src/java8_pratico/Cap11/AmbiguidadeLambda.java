package java8_pratico.Cap11;

import java.util.function.Supplier;
import java.security.PrivilegedAction;

public class AmbiguidadeLambda {

    /*
    Pontos Chave da Implementação:
    Demonstração do Problema:
    Mostra as duas interfaces funcionais com assinaturas idênticas
    Ilustra a chamada ambígua comentada

    Soluções Apresentadas:
    Casting explícito da expressão lambda
    Uso de referência de método como alternativa
    Atribuição a variável intermediária

    Casos de Uso Práticos:
    Quando você não controla as interfaces funcionais (API externa)
    Em frameworks que podem ter múltiplas interfaces compatíveis

    Boas Práticas:
    Evitar sobrecargas com interfaces funcionais muito similares
    Documentar claramente quando a ambiguidade pode ocorrer
    Preferir referências de método quando possível para maior clareza
    Esta situação é relativamente rara na prática, mas importante de entender para quando você encontrar mensagens de erro de ambiguidade ao trabalhar com expressões lambda em Java.

    */

    public static void main(String[] args) {
        // Casos não ambíguos (inferência funciona)
        Supplier<String> supplier = () -> "retorna uma String";
        PrivilegedAction<String> action = () -> "retorna uma String";

        // Chamada ambígua - causa erro de compilação
        // metodo(() -> "retorna uma String"); // Descomente para ver o erro

        // Soluções para a ambiguidade:
        // 1. Casting explícito
        metodo((Supplier<String>) () -> "retorna uma String");

        // 2. Referência de método
        //metodo(AmbiguidadeLambda::getString);

        // 3. Atribuição intermediária
        Supplier<String> sup = () -> "retorna uma String";
        metodo(sup);
    }

    // Métodos sobrecarregados que causam ambiguidade
    private static void metodo(Supplier<String> supplier) {
        System.out.println("Usando Supplier: " + supplier.get());
    }

    private static void metodo(PrivilegedAction<String> action) {
        System.out.println("Usando PrivilegedAction: " + action.run());
    }

    // Método auxiliar para referência de método
    private static String getString() {
        return "retorna uma String";
    }
}
