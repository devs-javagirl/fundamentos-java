package java8_pratico.Cap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperadorDiamanteExemplo {
  /*
    Pontos Chave da Implementa��o:
    Demonstra os tr�s contextos onde o operador diamante foi melhorado:
    Declara��o de vari�veis
    Passagem como par�metro
    Uso com m�todos utilit�rios como Collections.emptyList()
    Mostra a compatibilidade com vers�es anteriores (coment�rio do que era necess�rio no Java 7)
    Ilustra como a infer�ncia de tipos funciona baseada no contexto (par�metro do m�todo)
    Inclui exemplos pr�ticos do mundo real (como trabalhar com listas vazias)
    Esta melhoria na infer�ncia de tipos torna o c�digo mais limpo e reduz a verbosidade sem perder a seguran�a de tipos que o Java oferece.
 */
    public static void main(String[] args) {
        // Exemplo 1: Declara��o de vari�vel (funcionava desde Java 7)
        List<String> lista1 = new ArrayList<>();

        // Exemplo 2: Como argumento de m�todo (melhoria do Java 8)
        adicionarLista(new ArrayList<>()); // Infer�ncia de String pelo par�metro do m�todo

        // Exemplo 3: Collections.emptyList() (melhoria do Java 8)
        //adicionarLista(Collections.emptyList()); // Infer�ncia autom�tica

        // Exemplo 4: Java 7 exigia isto:
        //adicionarLista(Collections.<String>emptyList());
    }

    public static void adicionarLista(List<String> lista) {
        lista.add("Item adicionado");
        System.out.println("Lista recebida: " + lista);
    }

    // M�todo para simular o reposit�rio do exemplo
    public static class Repositorio {
        public void adiciona(List<Usuario> usuarios) {
            // implementa��o
        }
    }

    public static class Usuario {
        // classe de exemplo
    }
}
