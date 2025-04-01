package java8_pratico.Cap8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListarArquivos {
    public static void main(String[] args) {
        Path diretorio = Paths.get("C:/arq_estudo_java");

        try {
            Files.list(diretorio)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }

        //------------
        System.out.println("----------------------------");
        try {
            Files.list(Paths.get("C:/arq_estudo_java"))
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }
    }
}
