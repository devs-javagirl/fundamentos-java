package java8_pratico.Cap11;

import java.util.function.Supplier;
import java.security.PrivilegedAction;

public class AmbiguidadeLambda {

    /*
    Pontos Chave da Implementa��o:
    Demonstra��o do Problema:
    Mostra as duas interfaces funcionais com assinaturas id�nticas
    Ilustra a chamada amb�gua comentada

    Solu��es Apresentadas:
    Casting expl�cito da express�o lambda
    Uso de refer�ncia de m�todo como alternativa
    Atribui��o a vari�vel intermedi�ria

    Casos de Uso Pr�ticos:
    Quando voc� n�o controla as interfaces funcionais (API externa)
    Em frameworks que podem ter m�ltiplas interfaces compat�veis

    Boas Pr�ticas:
    Evitar sobrecargas com interfaces funcionais muito similares
    Documentar claramente quando a ambiguidade pode ocorrer
    Preferir refer�ncias de m�todo quando poss�vel para maior clareza
    Esta situa��o � relativamente rara na pr�tica, mas importante de entender para quando voc� encontrar mensagens de erro de ambiguidade ao trabalhar com express�es lambda em Java.

    */

    public static void main(String[] args) {
        // Casos n�o amb�guos (infer�ncia funciona)
        Supplier<String> supplier = () -> "retorna uma String";
        PrivilegedAction<String> action = () -> "retorna uma String";

        // Chamada amb�gua - causa erro de compila��o
        // metodo(() -> "retorna uma String"); // Descomente para ver o erro

        // Solu��es para a ambiguidade:
        // 1. Casting expl�cito
        metodo((Supplier<String>) () -> "retorna uma String");

        // 2. Refer�ncia de m�todo
        //metodo(AmbiguidadeLambda::getString);

        // 3. Atribui��o intermedi�ria
        Supplier<String> sup = () -> "retorna uma String";
        metodo(sup);
    }

    // M�todos sobrecarregados que causam ambiguidade
    private static void metodo(Supplier<String> supplier) {
        System.out.println("Usando Supplier: " + supplier.get());
    }

    private static void metodo(PrivilegedAction<String> action) {
        System.out.println("Usando PrivilegedAction: " + action.run());
    }

    // M�todo auxiliar para refer�ncia de m�todo
    private static String getString() {
        return "retorna uma String";
    }
}
