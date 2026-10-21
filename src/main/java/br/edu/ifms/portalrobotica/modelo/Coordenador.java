package br.edu.ifms.portalrobotica.modelo;

public class Coordenador {

    private int id;
    private String nome;
    private String minibio;
    private String foto;

    public Coordenador() {
    }

    public Coordenador(int id, String nome, String minibio, String foto) {
        this.id = id;
        this.nome = nome;
        this.minibio = minibio;
        this.foto = foto;
    }

    public Coordenador(String nome, String minibio, String foto) {
        this.nome = nome;
        this.minibio = minibio;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Coordenador [id=" + id
                + ", nome=" + nome
                + ", minibio=" + minibio
                + ", foto=" + foto + "]";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMinibio() {
        return minibio;
    }

    public String getFoto() {
        return foto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMinibio(String minibio) {
        this.minibio = minibio;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
