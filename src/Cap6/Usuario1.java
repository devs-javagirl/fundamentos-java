package Cap6;

public class Usuario1 {
    private String nome;
    private int pontos;

    public Usuario1(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
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

    @Override
    public String toString() {
        return nome + " (" + pontos + " pontos)";
    }
}
