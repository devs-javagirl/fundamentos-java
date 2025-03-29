package java8_pratico.Cap4;

class Usuario {
    private String nome;
    private int pontos;

    public Usuario(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    @Override
    public String toString() {
        return nome + " - " + pontos + " pontos";
    }
}
