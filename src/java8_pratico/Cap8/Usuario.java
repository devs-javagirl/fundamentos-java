package java8_pratico.Cap8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class Usuario {
    private String nome;
    private List<Pedido> pedidos;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public Stream<Pedido> getPedidos() {
        return pedidos.stream();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return nome != null ? nome.equals(usuario.nome) : usuario.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    @Override
    public String toString() {
        return nome;
    }
}

class Grupo {
    private Set<Usuario> usuarios = new HashSet<>();

    public void add(Usuario u) {
        usuarios.add(u);
    }

    public Stream<Usuario> getUsuarios() {
        return usuarios.stream();
    }
}

class Pedido {
    private String descricao;

    public Pedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Pedido: " + descricao;
    }
}

