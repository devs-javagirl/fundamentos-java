package java8_pratico.Cap3;

import java.util.List;
import java.util.function.Consumer;

public class Capitulo3Exemplo3 {
    public static void main(String[] args) {
        //Consumer<T>: Usado para consumir um valor sem retornar nada, como imprimir valores:
        Consumer<String> print = System.out::println;
        List<String> usuarios = List.of("Alice", "Bob", "Charlie");
        usuarios.forEach(print::accept);
    }
}
