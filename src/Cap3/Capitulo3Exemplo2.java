package Cap3;

public class Capitulo3Exemplo2 {
    public static void main(String[] args) {
        int numero = 5;
        new Thread(() -> {
            System.out.println(numero); // N�o compila!
        }).start();
        //numero = 10; // Vari�vel alterada ap�s ser usada no lambda
    }
}
