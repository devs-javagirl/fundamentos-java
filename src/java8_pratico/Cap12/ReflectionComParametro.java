package java8_pratico.Cap12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ReflectionComParametro {

    // Classe interna Usuario
    static class Usuario {
        private String nome;
        private int pontos;

        public Usuario(String nome, int pontos) {
            this.nome = nome;
            this.pontos = pontos;
        }
    }

    public static void main(String[] args) throws Exception {

        Constructor<Usuario> constructor =
                Usuario.class.getConstructor(String.class, int.class);

        Parameter[] parameters = constructor.getParameters();

        System.out.println("Nomes dos parâmetros do construtor:");
        Arrays.asList(parameters).forEach(param ->
                System.out.println(param.isNamePresent() + ": " + param.getName())
        );
    }
}

