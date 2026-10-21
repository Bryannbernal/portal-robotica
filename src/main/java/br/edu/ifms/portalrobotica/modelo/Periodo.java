package br.edu.ifms.portalrobotica.modelo;

public class Periodo {

    private int id;
    private int semestre;
    private int ano;

    public Periodo() {
    }

    public Periodo(int semestre, int ano) {
        this.semestre = semestre;
        this.ano = ano;
    }

    public Periodo(int id, int semestre, int ano) {
        this.id = id;
        this.semestre = semestre;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "PeriodoLetivo [id=" + id
                + ", ano=" + ano
                + ", semestre=" + semestre + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
