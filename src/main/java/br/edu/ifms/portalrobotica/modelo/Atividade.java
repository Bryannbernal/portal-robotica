package br.edu.ifms.portalrobotica.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Atividade {

    private int id;
    private String titulo;
    private String tipo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String situacao;
    private int coordenadorId;
    private Coordenador coordenador;

    public Atividade() {
    }

    public Atividade(String titulo, String tipo, String descricao, LocalDate dataInicio, LocalDate dataFim, String situacao, int coordenadorId) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.situacao = situacao;
        this.coordenadorId = coordenadorId;
    }

    public Atividade(int id, String titulo, String tipo, String descricao, LocalDate dataInicio, LocalDate dataFim, String situacao, int coordenadorId) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.situacao = situacao;
        this.coordenadorId = coordenadorId;
    }

    public Atividade(int id, String titulo, String tipo, String descricao, LocalDate dataInicio, LocalDate dataFim, String situacao, int coordenadorId, Coordenador coordenador) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.situacao = situacao;
        this.coordenadorId = coordenadorId;
        this.coordenador = coordenador;
    }

    public Atividade(String titulo, String tipo, String descricao, LocalDate dataInicio, LocalDate dataFim, String situacao, int coordenadorId, Coordenador coordenador) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.situacao = situacao;
        this.coordenadorId = coordenadorId;
        this.coordenador = coordenador;
    }

    @Override
    public String toString() {
        return "Atividade [id=" + id
                + ", titulo=" + titulo
                + ", tipo=" + tipo
                + ", descricao=" + descricao
                + ", dataInicio=" + dataInicio
                + ", dataFim=" + dataFim
                + ", situacao=" + situacao
                + ", coordenadorId=" + coordenadorId + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCoordenadorId() {
        return coordenadorId;
    }

    public void setCoordenadorId(int coordenadorId) {
        this.coordenadorId = coordenadorId;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public String getDataInicioFormatada() {
        if (dataInicio == null) {
            return "";
        }

        return dataInicio.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );
    }

    public String getDataFimFormatada() {
        if (dataFim == null) {
            return "";
        }

        return dataFim.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );
    }
}
