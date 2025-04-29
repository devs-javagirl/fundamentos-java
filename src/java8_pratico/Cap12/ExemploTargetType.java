package java8_pratico.Cap12;

import java.util.concurrent.Callable;
import java.security.PrivilegedAction;

public class ExemploTargetType {

    private static void exemploLambdaComErro() {
        // Object o = () -> System.out.println("erro"); // Não compila!
    }

    private static void exemploLambdaComRunnable() {
        Runnable r = () -> System.out.println("eu sou um runnable!");
        new Thread(r).start();
    }

    private static void exemploLambdaDireta() {
        new Thread(() -> System.out.println("eu sou um runnable?")).start();
    }

    private static void exemploTargetTypeComLambda() {
        Callable<String> c = () -> "retorna uma String";
        PrivilegedAction<String> p = () -> "retorna uma String";
        try {
            System.out.println(c.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(p.run());
    }

    private static void exemploTargetTypeComMethodReference() {
        ExemploCallable callable = new ExemploCallable();
        Callable<String> c = callable::call;
        PrivilegedAction<String> action = callable::call;
        try {
            System.out.println(c.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(action.run());
    }

    public static void main(String[] args) {
        exemploLambdaComRunnable();
        exemploLambdaDireta();
        exemploTargetTypeComLambda();
        exemploTargetTypeComMethodReference();
    }

    // Classe de apoio para method reference
    static class ExemploCallable {
        public String call() {
            return "chamada via method reference";
        }
    }
}

