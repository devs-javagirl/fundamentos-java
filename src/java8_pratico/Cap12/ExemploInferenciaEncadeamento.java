package java8_pratico.Cap12;

import java.util.*;

public class ExemploInferenciaEncadeamento {

    static class Usuario {
        private String nome;
        private int pontos;

        public Usuario(String nome, int pontos) {
            this.nome = nome;
            this.pontos = pontos;
        }

        public String getNome() {
            return nome;
        }

        public int getPontos() {
            return pontos;
        }

        @Override
        public String toString() {
            return nome + " (" + pontos + " pontos)";
        }
    }

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>(List.of(
                new Usuario("Ana", 150),
                new Usuario("Carlos", 120),
                new Usuario("Bruna", 120)
        ));

        // Usando method reference: funciona bem
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos)
                .thenComparing(Usuario::getNome));
        usuarios.forEach(System.out::println);

        System.out.println("---");

        // Usando lambda com tipo explícito
        usuarios.sort(Comparator.comparingInt((Usuario u) -> u.getPontos())
                .thenComparing(u -> u.getNome()));
        usuarios.forEach(System.out::println);

        System.out.println("---");
        usuarios.sort(Comparator.comparingInt((Usuario u) -> u.getPontos()).reversed());
        usuarios.forEach(System.out::println);


    }
}

