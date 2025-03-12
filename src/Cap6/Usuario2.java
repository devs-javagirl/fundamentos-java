package Cap6;

public class Usuario2 {
    private String nome;
    private int pontos;
    private boolean moderador;

    public Usuario2(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = false;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean isModerador() {
        return moderador;
    }

    public void tornaModerador() {
        this.moderador = true;
    }

    public void tornaUsuario(){this.moderador = false;}

    @Override
    public String toString() {
        return nome + " (" + pontos + " pontos) " + (isModerador() ? ". É moderador." : ". Não é moderador.");
    }
}
