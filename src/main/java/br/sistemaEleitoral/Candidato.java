package br.sistemaEleitoral;

public class Candidato {
    private String nome;
    private int numbero;
    private Partido partido;

    public Candidato(String nome, int numbero, Partido partido) {
        this.nome = nome;
        this.numbero = numbero;
        this.partido = partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumbero() {
        return numbero;
    }

    public void setNumbero(int numbero) {
        this.numbero = numbero;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public String toString() {
        return "Nome: " +this.nome + "\nPartido: " +this.numbero + "\nPartido: " + this.getPartido();
    }
}
