package java8_pratico.Cap6;

import java.util.function.BiFunction;

public class BiFunctionReferenceConstructor {
    public static void main(String[] args) {
        // Refer�ncia ao construtor com dois par�metros
        BiFunction<String, Integer, Usuario2> criadorDePessoas = Usuario2::new;
        // Criando uma nova inst�ncia de Pessoa
        Usuario2 pessoa = criadorDePessoas.apply("Maria", 30);
        System.out.println(pessoa); // Output: Pessoa{nome='Maria', idade=30}
    }
}
