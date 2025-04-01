package java8_pratico.Cap9;

public class Usuario {
    private Long id;
    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario(Long id, String nome, int pontos, boolean moderador) {
        this.id = id;
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = moderador;
    }

    public Usuario(String nome, int pontos, boolean moderador) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = moderador;
    }

    public Usuario(String nome, int pontos) {
        this(nome, pontos, false);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pontos=" + pontos +
                ", moderador=" + moderador +
                '}';
    }
}
