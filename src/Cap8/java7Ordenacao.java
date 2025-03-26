package Cap8;

import Cap6.Usuario2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class java7Ordenacao {
    public static void main(String[] args) {
        List<Usuario2> usuarios = new ArrayList<>();
        usuarios.add(new Usuario2("Carlos", 150));
        usuarios.add(new Usuario2("Ana", 10));
        usuarios.add(new Usuario2("Alice", 90));
        usuarios.add(new Usuario2("Bruno", 180));
        usuarios.add(new Usuario2("Manuela", 300));
        usuarios.add(new Usuario2("Luiza", 320));
        usuarios.add(new Usuario2("Luis", 210));
        usuarios.add(new Usuario2("Daniela", 321));
        usuarios.add(new Usuario2("Eduardo", 478));
        usuarios.add(new Usuario2("Fernanda", 15));

        usuarios.add(new Usuario2("Gabriel", 62));
        usuarios.add(new Usuario2("Helena", 500));
        usuarios.add(new Usuario2("Igor", 275));
        usuarios.add(new Usuario2("Juliana", 120));

        List<Usuario2> usuariosFiltrados = new ArrayList<>();
        for(Usuario2 usuario : usuarios) {
            if(usuario.getPontos() > 100) {
                usuariosFiltrados.add(usuario);
            }
        }

        Collections.sort(usuariosFiltrados, new Comparator<Usuario2>() {
            public int compare(Usuario2 u1, Usuario2 u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        });

        usuariosFiltrados.forEach(System.out::println);
    }
}
