package java8_pratico.Cap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperadorDiamanteExemplo {
  /*
    Pontos Chave da Implementação:
    Demonstra os três contextos onde o operador diamante foi melhorado:
    Declaração de variáveis
    Passagem como parâmetro
    Uso com métodos utilitários como Collections.emptyList()
    Mostra a compatibilidade com versões anteriores (comentário do que era necessário no Java 7)
    Ilustra como a inferência de tipos funciona baseada no contexto (parâmetro do método)
    Inclui exemplos práticos do mundo real (como trabalhar com listas vazias)
    Esta melhoria na inferência de tipos torna o código mais limpo e reduz a verbosidade sem perder a segurança de tipos que o Java oferece.
 */
    public static void main(String[] args) {
        // Exemplo 1: Declaração de variável (funcionava desde Java 7)
        List<String> lista1 = new ArrayList<>();

        // Exemplo 2: Como argumento de método (melhoria do Java 8)
        adicionarLista(new ArrayList<>()); // Inferência de String pelo parâmetro do método

        // Exemplo 3: Collections.emptyList() (melhoria do Java 8)
        //adicionarLista(Collections.emptyList()); // Inferência automática

        // Exemplo 4: Java 7 exigia isto:
        //adicionarLista(Collections.<String>emptyList());
    }

    public static void adicionarLista(List<String> lista) {
        lista.add("Item adicionado");
        System.out.println("Lista recebida: " + lista);
    }

    // Método para simular o repositório do exemplo
    public static class Repositorio {
        public void adiciona(List<Usuario> usuarios) {
            // implementação
        }
    }

    public static class Usuario {
        // classe de exemplo
    }
}
