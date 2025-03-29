package Cap6;

public class Usuario2 {
    private String nome;
    private int pontos;
    private boolean moderador;

    public static boolean mod;

    public Usuario2(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = false;
    }

    public Usuario2(String nome, Integer pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.moderador = false;
    }

    public Usuario2(String nome, boolean mod) {
        this.nome = nome;
        this.moderador = mod;
    }

    public Usuario2() {

    }

    public Usuario2(String n) {
        this.nome = n;
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

    public static void tornaModerador2() {
        mod = true;
        System.out.println("Tornando moderador...");
    }

    public void tornaUsuario(){this.moderador = false;}


    @Override
    public String toString() {
        return nome + " (" + pontos + " pontos) " + (isModerador() ? ". É moderador." : ". Não é moderador.");
    }

    public void setPontos(int i) {
        this.pontos = i;
    }
}
