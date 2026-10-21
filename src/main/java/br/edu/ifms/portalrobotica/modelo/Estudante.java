package br.edu.ifms.portalrobotica.modelo;

public class Estudante {

    private int id;
    private String nome;
    private String minibio;
    private String foto;

    public Estudante() {}

    public Estudante(int id, String nome, String minibio, String foto) {
        this.id = id;
        this.nome = nome;
        this.minibio = minibio;
        this.foto = foto;
    }

    public Estudante(String nome, String minibio, String foto) {
        this.nome = nome;
        this.minibio = minibio;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Estudante [id=" + id
                + ", nome=" + nome
                + ", minibio=" + minibio
                + ", foto=" + foto + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMinibio() {
        return minibio;
    }

    public void setMinibio(String minibio) {
        this.minibio = minibio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}