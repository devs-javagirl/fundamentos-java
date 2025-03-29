package java8_pratico.Cap5;

@FunctionalInterface
interface Operacao {
    int executar(int a, int b);

    default void imprimirResultado(int a, int b) {
        System.out.println("Resultado: " + executar(a, b));
    }
}
public class Exemplo2 {
        public static void main(String[] args) {
            Operacao soma = (a, b) -> a * b;
            soma.imprimirResultado(3, 5);
        }

}
