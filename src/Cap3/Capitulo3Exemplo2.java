package Cap3;

public class Capitulo3Exemplo2 {
    public static void main(String[] args) {
        int numero = 5;
        new Thread(() -> {
            System.out.println(numero); // Não compila!
        }).start();
        //numero = 10; // Variável alterada após ser usada no lambda
    }
}
